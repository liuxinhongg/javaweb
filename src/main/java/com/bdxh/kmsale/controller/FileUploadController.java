package com.bdxh.kmsale.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bdxh.kmsale.bean.AbstractEntity;


@Controller
@RequestMapping("/attachment")
public class FileUploadController extends AbstractBackendController<AbstractEntity, Long> {

	public static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	protected void mkdir(String dir) {
		if (StringUtils.isBlank(dir)) {
			throw new IllegalArgumentException();
		}
		File file = new File(dir);
		mkdir(file);
	}

	protected void mkdir(File file) {
		if (file == null || !file.isDirectory()) {
			if (file.getParentFile().exists()) {
				file.mkdir();
			} else {
				mkdir(file.getParentFile().getAbsolutePath());
				file.mkdir();
			}
		}
	}	

	/**
	 * 图片上传
	 * @param files
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/img/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> uploadImage(@RequestParam("userhead") MultipartFile userhead, MultipartHttpServletRequest request) {
		initProps();
		List<Map<String, String>> urls = new ArrayList<Map<String, String>>();
		String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_";
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			newFileName += random.nextInt(9);
		}

		String tmpNewFileName = newFileName;
		if (userhead != null) {
			String fileName = userhead.getOriginalFilename();
			String suffix = fileName.lastIndexOf(".") >= 0 ? fileName.substring(fileName.lastIndexOf(".")) : "";
			// 分类目录
			String dir = "img";
			// 分类目录文件夹路径
			String targetDir = uploadPath + "/" + dir + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date());
			mkdir(targetDir);
			newFileName = tmpNewFileName;
			newFileName += suffix;
			try {
//				upload(mpf.getBytes(),targetDir + "/" + newFileName);
				FileCopyUtils.copy(userhead.getBytes(), new FileOutputStream(targetDir + "/" + newFileName));
				String url = uploadContextPath + "/" + dir + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + newFileName;
				Map<String, String> map = new HashMap<String, String>();
				map.put("url", url);
				urls.add(map);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", Long.valueOf(200));
		map.put("urls", urls);
		return getJsonResponseEntity(map);
	}
}

package com.bdxh.kmsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.utils.PoiExcelTool;

@Controller
@RequestMapping("/importExcel")
public class ImportController extends AbstractBackendController<AbstractEntity, Long>{

	
	@RequestMapping(value = "/{identity}/import", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map> execute(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "identity") String identity, ModelMap model) {
		MultipartHttpServletRequest mult = (MultipartHttpServletRequest) request;
		MultipartFile file = mult.getFile("file");
		String filename = file.getOriginalFilename();
		String exten = filename.substring(filename.lastIndexOf(".") + 1);
		if (!"xls".equalsIgnoreCase(exten) && !"xlsx".equalsIgnoreCase(exten)) {
			return null;
		}
		// 获取excel数据的集合
		List<String[]> dataList = null;
		// 参数设置
		HashMap<String, Object> params = new HashMap<String, Object>();

		// 存放excel行数据、列数据教研结果的集合，并返回
		HashMap<String, Object> logMap = new HashMap<String, Object>();

		PoiExcelTool et;
		String path = "";
		String backurl = "";
		try {
			et = new PoiExcelTool(file.getInputStream());
			dataList = et.getAllData();
			if (identity.equalsIgnoreCase("student")) {
				initProps();
				params.put("uploadPath", uploadPath);
				params.put("uploadContextPath", uploadContextPath);

				// 导入模板
//				logMap = studentService.importFile(logMap, dataList, params);
				path = "/basic/student/import";
				backurl = "/basic/student/student";
			}  else {
				return null;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iserror", logMap.get("iserror"));
		map.put("message", logMap.get("message"));
		map.put("errorList", logMap.get("errorList"));
		map.put("backurl", backurl);
		return getJsonResponseEntity(map);
	}
}

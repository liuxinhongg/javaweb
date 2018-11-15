package com.bdxh.kmsale.controller.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.controller.AbstractBackendController;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月12日,上午9:55:09
 * @Description 下载文件的工具
 */
@Controller
@RequestMapping("/utilDown")
public class utilDown extends AbstractBackendController<AbstractEntity, Long> {
	/**
     * 下载Excel模板
     * @param fileName
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/downLoad",method = RequestMethod.GET)
	public  @ResponseBody ResponseEntity<String> downLoad(
			HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//获取要下载的模板名称
			String fileName = request.getParameter("fileName");
			//设置要下载的文件的名称
			response.setHeader("Content-disposition","attachment;fileName="+fileName);
			//通知客服文件的MIME类型
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			//获取文件的路径
			String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/file")+"/"+fileName;
			filePath = filePath.replace("\\", "/");
			InputStream input = null;
			OutputStream out =null;
			try {
				input = new FileInputStream(filePath);
				out =response.getOutputStream();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] b = new byte[2048];
			int len;
			try {
				while((len=input.read(b))!=-1){
					out.write(b,0,len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			map.put("state", 0);
			map.put("msg", "下载成功");
		} catch (Exception e) {
			map.put("state", -1);
			map.put("msg", "下载失败");
		}
		return getJsonResponseEntity(map);
	} 
	
}

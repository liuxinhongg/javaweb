package com.bdxh.kmsale.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.bdxh.kmsale.service.AgentService;

/**
* @author  作者:Binzh
* @version 创建时间：2018年10月23日 下午11:11:41
*          类说明:业务编号生成工具类
*/
public class NumberUtils {
	//业务编号
	private  static String noNumber; 
	
	@Autowired
	private AgentService anentService;
	public NumberUtils(String fatherNumber){
		if(fatherNumber.equals("")||fatherNumber==null){
		
		}	
	}
	public NumberUtils(){
		
	}
}

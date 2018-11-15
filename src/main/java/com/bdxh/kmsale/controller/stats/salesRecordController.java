package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:54:06
 * @Description 销售记录
 */
@Controller
@RequestMapping("/stats/salesRecord")
public class salesRecordController {
	@RequestMapping("")
	public String show() {
		return "stats/salesRecord";
	}
}

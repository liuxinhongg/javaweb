package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:52:36
 * @Description 分部考核
 */
@Controller
@RequestMapping("/stats/branchAssess")
public class branchAssessController {
	
	@RequestMapping("")
	public String show() {
		return "stats/branchAssess";
	}
	
}

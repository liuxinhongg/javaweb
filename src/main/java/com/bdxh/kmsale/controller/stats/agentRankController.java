package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:52:26
 * @Description 代理人排行
 */
@Controller
@RequestMapping("/stats/agentRank")
public class agentRankController {
	
	@RequestMapping("")
	public String show() {
		return "stats/agentRank";
	}
	
}

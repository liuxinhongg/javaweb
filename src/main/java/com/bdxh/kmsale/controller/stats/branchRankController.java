package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:54:19
 * @Description 分区经理排行
 */
@Controller
@RequestMapping("/stats/branchRank")
public class branchRankController {
	@RequestMapping("")
	public String show() {
		return "stats/branchRank";
	}
}

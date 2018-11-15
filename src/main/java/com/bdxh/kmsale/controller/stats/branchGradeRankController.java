package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:52:56
 * @Description 分区业绩排行
 */
@Controller
@RequestMapping("/stats/branchGradeRank")
public class branchGradeRankController {

	@RequestMapping("")
	public String show() {
		return "stats/branchGradeRank";
	}
}

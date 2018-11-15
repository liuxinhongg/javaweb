package com.bdxh.kmsale.controller.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月14日,下午4:53:37
 * @Description 用户明细
 */
@Controller
@RequestMapping("/stats/userDetails")
public class userDetailsController {
	@RequestMapping("")
	public String show() {
		return "stats/userDetails";
	}
	/**
	 * 欠费
	 * @return
	 */
	@RequestMapping("/arrearage")
	public String showUserArrearage() {
		return "stats/userArrearage";
	}
	/**
	 * 到期
	 * @return
	 */
	@RequestMapping("/Expire")
	public String showUserExpire() {
		return "stats/userExpire";
	}
}

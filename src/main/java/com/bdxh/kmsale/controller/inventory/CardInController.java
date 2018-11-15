package com.bdxh.kmsale.controller.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/cardIn")
public class CardInController {
	
	//显示导入SIM卡页面
		@RequestMapping("/getCardIn")
		public String getCardIn(){
			return "system/cardIn";
		}
	
	

}

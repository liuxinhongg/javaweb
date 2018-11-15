package com.bdxh.kmsale.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.UserService;
import com.bdxh.kmsale.utils.Encrypt;

@Controller
@RequestMapping("/manage")
public class ManagementController extends AbstractBackendController<AbstractEntity, Long> {

	@Resource
	private UserService userService;

	@RequestMapping("/index")
	public String index(ModelMap mode, HttpSession session) {

		mode.addAttribute("user", session.getAttribute(Constants.SESSION_USER));

		return "manage/index";
	}

	@RequestMapping("/main")
	public String main(ModelMap mode, HttpSession session) {

		mode.addAttribute("user", session.getAttribute(Constants.SESSION_USER));

		return "manage/main";
	}

	@RequestMapping("/userhead")
	public String userhead(ModelMap mode, HttpSession session) {

		mode.addAttribute("user", session.getAttribute(Constants.SESSION_USER));

		return "manage/profile/userhead";
	}

	@RequestMapping("/toUpdatePwd")
	public String toUpdatePwd(ModelMap mode, HttpSession session) {

		mode.addAttribute("user", session.getAttribute(Constants.SESSION_USER));

		return "manage/profile/changePwd";
	}

	// 修改密码
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> updatePassword(String oldPwd, String newPwd, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			User user = (User) session.getAttribute(Constants.SESSION_USER);

			Encrypt encrypt = new Encrypt();
			oldPwd = encrypt.encode(oldPwd);
			newPwd = encrypt.encode(newPwd);
			userService.changePassword(user.getLoginId(), oldPwd, newPwd);
			map.put("state", 0);
			map.put("msg", "修改成功");
		} catch (RuntimeException e) {
			map.put("state", -1);
			map.put("msg", "修改失败");
		}
		return getJsonResponseEntity(map);
	}

}

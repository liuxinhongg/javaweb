package com.bdxh.kmsale.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.AbstractBackendController;
import com.bdxh.kmsale.service.system.UserService;

@RestController
@RequestMapping("/api/user")
public class UserAPI extends AbstractBackendController<AbstractEntity, Long>{

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "toLogin",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> tologin(@RequestBody User user2,
			HttpServletResponse response,
			HttpSession session) {
		Map<String, Object> map=new HashMap<String, Object>();
		String loginId =user2.getLoginId();
		String password =user2.getPassword();
		System.out.println(loginId+"="+password);
		try {
			User user = userService.login(loginId,password);
				map.put("state", 0);
				map.put("message", "登录成功");
				session.setAttribute(Constants.SESSION_USER, user);
				Cookie cookie = new Cookie("user", user.getLoginId());
				response.addCookie(cookie);
		} catch (RuntimeException e) {
			if(e.getMessage().equals("密码错误")||e.getMessage().equals("用户名不存在")) {				
				map.put("state", -1);
				map.put("message", e.getMessage());
			}else{
				map.put("state", -1);
				map.put("message","服务异常,请稍后重试");
			}
		}
		System.out.println("输出map"+getJsonResponseEntity(map).toString());
		return getJsonResponseEntity(map);  
	}
}

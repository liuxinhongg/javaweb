package com.bdxh.kmsale.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdxh.kmsale.bean.AbstractEntity;
import com.bdxh.kmsale.bean.system.ResponseResult;
import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.controller.util.Checkcode;
import com.bdxh.kmsale.service.system.impl.UserServiceImpl;
import com.bdxh.kmsale.utils.CookiesUtil;
import com.bdxh.kmsale.utils.Encrypt;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractBackendController<AbstractEntity, Long>{

	@Resource
	private UserServiceImpl userService;

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

	//显示login页面
	@RequestMapping("/showLogin")
	public String showLogin(){
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(ModelMap mode ,
			@RequestParam(value="username",required=false) String loginId,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="remFlag",required=false) Boolean remFlag,
			HttpSession session,HttpServletResponse response){
		ResponseResult rr =new  ResponseResult();
    /*Integer loginErrorCount = (Integer)session.getAttribute("loginErrorCount");
		if (loginErrorCount == null) {
			loginErrorCount = Integer.valueOf(0);
		   }  
		if ((loginErrorCount != null) && (loginErrorCount.intValue() > 2)){
			
		}*/
		try {
			Encrypt encrypt = new Encrypt();
			String userpwd=encrypt.encode(password);
			User user = userService.login(loginId,userpwd);
			session.setAttribute(Constants.SESSION_USER, user);
			CookiesUtil.setCookie(response, "user", user.getLoginId(), 30*24*60*60);
			//记住密码
			if(remFlag) {
				CookiesUtil.setCookie(response, "loginInfo", loginId + "#" + password, 30*24*60*60);
			}else {
				CookiesUtil.setCookie(response, "loginInfo", loginId + "#" + password, 0);
			}
			rr.setState(0);
			rr.setMessage("登录成功");
			redisTemplate.set("user"+ user.getLoginId(), user);
		} catch (RuntimeException e) {
			rr.setState(-1);
			rr.setMessage(e.getMessage());
			/*loginErrorCount = Integer.valueOf(loginErrorCount.intValue() + 1);
			session.setAttribute("loginErrorCount", loginErrorCount);*/
		}
		//2、使用JSONArray
		JSONObject jsonObject= (JSONObject) JSON.toJSON(rr);
		return jsonObject;
	}


	/**
	 * 获取验证码
	 * 
	 * @param response
	 * @param session
	 */
	@RequestMapping("/getVerifyCode")
	public void generate(HttpServletResponse response, HttpSession session) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String verifyCodeValue = Checkcode.DrawImg(output);
		session.setAttribute("verifyCodeValue", verifyCodeValue);
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//显示login页面
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response){
		User user = (User) session.getAttribute(Constants.SESSION_USER);
		if(null != user) {
			try {
				redisTemplate.del("user" + user.getLoginId());
				CookiesUtil.setCookie(response, "user", user.getLoginId(), 0);
				session.removeAttribute(Constants.SESSION_USER);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		return "login";
	}
}

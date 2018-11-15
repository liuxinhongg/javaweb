package com.bdxh.kmsale.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bdxh.kmsale.bean.system.User;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OAuthInterceptor implements HandlerInterceptor {
    
	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

    @PostConstruct
    public void init() {
    	
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        	
		Object object = request.getSession().getAttribute(Constants.SESSION_USER);

		if (null != object) {

			return true;
			
		} else {
			
			Cookie[] cookies = request.getCookies();

			for (Cookie cookie : cookies) {

				if (cookie.getName().equals("user")) {

					User user = (User) redisTemplate.get("user" + cookie.getValue());

					request.getSession().setAttribute(Constants.SESSION_USER, user);

					return true;
				}
			}
			response.sendRedirect("/user/showLogin.do");
		}

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

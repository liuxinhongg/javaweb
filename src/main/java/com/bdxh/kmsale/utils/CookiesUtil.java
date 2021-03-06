package com.bdxh.kmsale.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {

	public static Cookie getCookieByName(HttpServletRequest request, String name) {

		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {

		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value, int time) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		try {
			URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(time);
		response.addCookie(cookie);
		return response;
	}

	@SuppressWarnings("unused")
	private void delectCookieByName(HttpServletRequest request, HttpServletResponse response, String deleteKey)
			throws NullPointerException {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		for (String key : cookieMap.keySet()) {
			if (key == deleteKey && key.equals(deleteKey)) {
				Cookie cookie = cookieMap.get(key);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}

}

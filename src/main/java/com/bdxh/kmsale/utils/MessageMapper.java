package com.bdxh.kmsale.utils;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

public class MessageMapper {

	private static MessageMapper _INSTANCE = null;

	private MessageSource messageSource;

	private MessageMapper() {
		messageSource = SpringBeanUtils.getBean("messageSource");
	}

	public static MessageMapper getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new MessageMapper();
		}
		return _INSTANCE;
	}

	public String getMessage(String code) {
		return getMessage(code, null);
	}

	public String getMessage(String code, Object[] args) {
		return getMessage(code, args, StringUtils.EMPTY, Locale.CHINA);
	}

	public String getMessage(String code, Object[] args, Locale locale) {
		try {
			return messageSource.getMessage(code, args, locale);
		} catch (Exception e) {
			return code;
		}
	}

	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		try {
			String message = messageSource.getMessage(code, args, defaultMessage, locale);
			return StringUtils.isBlank(message) ? code : message;
		} catch (Exception e) {
			return code;
		}
	}
}

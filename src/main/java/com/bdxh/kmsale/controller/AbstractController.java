package com.bdxh.kmsale.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.bdxh.kmsale.cache.redis.RedisTemplate;
import com.bdxh.kmsale.common.Constants;
import com.bdxh.kmsale.utils.Permissions;
import com.bdxh.kmsale.utils.Persistable;
import com.bdxh.kmsale.utils.PropertiesLoader;
import com.bdxh.kmsale.utils.ReflectUtils;
import com.bdxh.kmsale.utils.RenderUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.core.annotation.AnnotationUtils;

public class AbstractController<M extends Persistable, ID extends Serializable> {
	
	
	private final String RESPONSE_ENTITY_JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + "; charset=" + Constants.ENCODING_UTF8;

	private final String RESPONSE_ENTITY_TEXT_TYPE = MediaType.TEXT_HTML_VALUE + "; charset=" + Constants.ENCODING_UTF8;

	// 学段（学历）
	protected final String _EDUCATION = "education";

	protected final Class<M> entityClass;

	private String viewPrefix;

	protected Permissions permissions;

	protected PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

	protected AbstractController() {
		this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
		setViewPrefix(defaultViewPrefix());
	}

	protected void setResourceIdentity(String resourceIdentityPrefix) {
		if (StringUtils.isNotBlank(resourceIdentityPrefix)) {
			permissions = Permissions.newPermissions(resourceIdentityPrefix);
		}
	}

	protected String defaultViewPrefix() {
		String currentViewPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentViewPrefix = requestMapping.value()[0];
		}

		if (StringUtils.isEmpty(currentViewPrefix)) {
			currentViewPrefix = this.entityClass.getSimpleName();
		}

		return currentViewPrefix;
	}

	public void setViewPrefix(String viewPrefix) {
		if (viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}
		this.viewPrefix = viewPrefix;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	protected String viewName(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return getViewPrefix() + suffixName;
	}

	protected String redirectToUrl(String backURL) {
		if (StringUtils.isEmpty(backURL)) {
			backURL = getViewPrefix();
		}
		if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
			backURL = "/" + backURL;
		}
		return "redirect:" + backURL;
	}

	protected <T> ResponseEntity<T> getJsonResponseEntity(Object obj) {
		if (obj != null) {
			return RenderUtils.getJsonResponseEntity(obj);
		}
		return null;
	}

	protected ResponseEntity<String> getScriptResponseEntity(Object obj) {
		if (obj != null) {
			return RenderUtils.getScriptResponseEntity(obj);
		}
		return null;
	}

	protected ResponseEntity<Map<String, Object>> getErrorScriptResponseEntity(String message) {

		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put("error", 1);
		obj.put("message", message);
		return RenderUtils.getScriptResponseEntity(obj);
	}

}

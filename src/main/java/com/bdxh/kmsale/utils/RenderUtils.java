package com.bdxh.kmsale.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bdxh.kmsale.utils.json.JsonMapper;

@SuppressWarnings("unchecked")
public class RenderUtils {

	public static <T> ResponseEntity<T> getJsonResponseEntity(Object obj) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", MediaTypes.APPLICATION_JSON_UTF_8);
		String json = JsonMapper.nonNullMapper().toJson(obj);

		return new ResponseEntity(json, responseHeaders, HttpStatus.OK);
	}

	public static <T> ResponseEntity<T> getScriptResponseEntity(Object obj) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", MediaTypes.TEXT_PLAIN_UTF_8);
		return new ResponseEntity(obj.toString(), responseHeaders, HttpStatus.OK);
	}
}

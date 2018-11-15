package com.bdxh.kmsale.utils;

import java.util.Map;
import java.util.Set;
import com.google.common.collect.Maps;
import com.bdxh.kmsale.utils.json.JsonMapper;


public class EnvironmentAttributes {

	private static EnvironmentAttributes _INSTANCE = null;

	private static PropertiesLoader propertiesLoader = null;

	private static Map<String, Object> attributes = null;

	private EnvironmentAttributes() {
		propertiesLoader = PropertiesLoader.getInstance();
		attributes = Maps.newTreeMap();

		register();
	}

	private EnvironmentAttributes(String... properties) {
		propertiesLoader = PropertiesLoader.getInstance(properties);
		attributes = Maps.newTreeMap();

		register();
	}

	private void register() {
		Set<Object> keys = propertiesLoader.getKeys();
		if (keys != null && !keys.isEmpty()) {
			String key = null;
			String value = null;
			for (Object keyObj : keys) {
				key = keyObj.toString();
				value = propertiesLoader.getProperty(key);
				if (!attributes.containsKey(key)) {
					attributes.put(key, value);
				}
			}
		}
	}

	public static EnvironmentAttributes getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new EnvironmentAttributes();
		}
		return _INSTANCE;
	}

	public static EnvironmentAttributes getInstance(String... properties) {
		if (_INSTANCE == null) {
			if (properties == null) {
				_INSTANCE = new EnvironmentAttributes();
			} else {
				_INSTANCE = new EnvironmentAttributes(properties);
			}
		}
		return _INSTANCE;
	}

	public String getProperty(String key) {
		return getProperty(key, null);
	}

	public String getProperty(String key, String defaultValue) {
		if (attributes.containsKey(key)) {
			return attributes.get(key).toString();
		}
		return defaultValue;
	}

	public Boolean getBoolean(String key) {
		return getBoolean(key, Boolean.FALSE);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {
		if (attributes.containsKey(key)) {
			return Boolean.parseBoolean(attributes.get(key).toString());
		}
		return defaultValue;
	}

	public String getAllProperties() {
		String attrs = JsonMapper.allMapper().toJson(attributes);
		return attrs;
	}

	public void setProperty(String key, String value) {
		if (attributes.containsKey(key)) {
			attributes.remove(key);
		}

		attributes.put(key, value);
	}
}

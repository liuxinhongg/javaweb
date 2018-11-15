package com.bdxh.kmsale.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.google.common.collect.Maps;

public class PropertiesLoader {

	private ResourceLoader loader = new DefaultResourceLoader();

	private Properties properties;

	private static Map<String, PropertiesLoader> _MAP = null;

	private static final String _DEFAULT = "default";

	private PropertiesLoader() {
		this("classpath:application.properties");
	}

	private PropertiesLoader(String... resourcePaths) {
		properties = loadProperties(resourcePaths);
	}

	public static PropertiesLoader getInstance() {
		return getInstance(new String[] {});
	}

	public static PropertiesLoader getInstance(String... properties) {
		
		String key = _DEFAULT;
		
		if (_MAP == null) {
			_MAP = Maps.newConcurrentMap();
		}
		
		if (properties != null && properties.length > 0) {
			
			StringBuilder build = new StringBuilder();
			for(String eKey : properties) {
				build.append(eKey);
			}
			key = Md5Utils.hash(build.toString());

			if (!_MAP.containsKey(key)) {
				_MAP.put(key, new PropertiesLoader(properties));	
			}
		}else {
			if (!_MAP.containsKey(_DEFAULT)) {
				_MAP.put(_DEFAULT, new PropertiesLoader());
			}
		}
		
		return _MAP.get(key);
	}
	
	public String getProperty(String key) {
		String property = System.getProperty(key);
		if (StringUtils.isNotBlank(property)) {
			return property;
		}
		properties = getProperties();
		return properties.getProperty(key);
	}

	public Set<Object> getKeys() {
		properties = getProperties();
		return properties.keySet();
	}

	public String getProperty(String key, String defaultValue) {
		String property = getProperty(key);
		return StringUtils.isBlank(property) ? defaultValue : property;
	}

	public Integer getInteger(String key) {
		String property = getProperty(key);
		return Integer.valueOf(property);
	}

	public Integer getInteger(String key, Integer defaultValue) {
		String property = getProperty(key);
		return StringUtils.isBlank(property) ? defaultValue : Integer.valueOf(property);
	}

	public Double getDouble(String key) {
		String property = getProperty(key);
		return Double.valueOf(property);
	}

	public Double getDouble(String key, Double defaultValue) {
		String property = getProperty(key);
		return StringUtils.isBlank(property) ? defaultValue : Double.valueOf(property);
	}

	public Boolean getBoolean(String key) {
		String property = getProperty(key);
		return Boolean.valueOf(property);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {
		String property = getProperty(key);
		return StringUtils.isBlank(property) ? defaultValue : Boolean.valueOf(property);
	}

	private Properties getProperties() {
		if (properties == null) {
			properties = loadProperties("classpath:application.properties");
		}
		return properties;
	}

	private Properties loadProperties(String... resourcePaths) {
		Properties properties = new Properties();
		for (String location : resourcePaths) {

			InputStream is = null;
			try {
				Resource resource = loader.getResource(location);
				is = resource.getInputStream();
				properties.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		return properties;
	}
}

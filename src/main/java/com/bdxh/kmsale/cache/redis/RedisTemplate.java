package com.bdxh.kmsale.cache.redis;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.bdxh.kmsale.utils.EnvironmentAttributes;
import com.bdxh.kmsale.utils.ObjectSerialize;
import redis.clients.jedis.HostAndPort;

public class RedisTemplate{

	private static final String CLUSTER = "redis.cluster";

	private String clusters = CLUSTER;

	private static volatile RedisAdapter adapter;

	private static RedisTemplate _INSTANCE = null;

	private RedisTemplate() {
		EnvironmentAttributes attributes = EnvironmentAttributes.getInstance();
		String cluster = attributes.getProperty(getClusters(), StringUtils.EMPTY).trim();
		if (StringUtils.isNotBlank(cluster)) {

			String[] hp = null;
			if (cluster.split(",").length > 1) {
				Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
				for (String hostAndPort : cluster.split(",")) {
					hp = hostAndPort.split(":");
					jedisClusterNodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
				}
				adapter = new JedisClusterExt(jedisClusterNodes);
			} else {
				hp = cluster.split(":");
				adapter = new JedisExt(hp[0], Integer.parseInt(hp[1]));
			}
		}
	}

	public static RedisTemplate getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new RedisTemplate();
		}
		return _INSTANCE;
	}

	public <T> T get(final String key) {
		// TODO: 序列化成字节数组
		if (adapter != null) {
			return (T) ObjectSerialize.deserialization(adapter.doGet(key));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final String key, final Class<?> classType) {

		if (adapter != null) {
			return (T) ObjectSerialize.deserialization(adapter.doGet(key));
		}
		return null;
	}

	public void set(final String key, final Object value) {
		// TODO: 反序列化成字节数组
		if (adapter != null) {
			adapter.doSet(key, ObjectSerialize.serialization(value));
		}
	}

	public void setex(String key, final Object value, int seconds) {
		if (adapter != null) {
			adapter.doSetex(key, seconds, ObjectSerialize.serialization(value));
		}
	}

	public Long setnx(String key, final Object value) {
		if (adapter != null) {
			return adapter.doSetnx(key, ObjectSerialize.serialization(value));
		}
		return 0l;
	}

	@SuppressWarnings("unchecked")
	public <T> T getSet(String key, final Object value, final Class<?> classType) {
		if (adapter != null) {
			return (T) ObjectSerialize.deserialization(adapter.getSet(key, ObjectSerialize.serialization(value)));
		}
		return null;
	}

	public Long del(final String key) {
		if (adapter != null) {
			
			try {
				return adapter.doDel(key);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0L;
	}

	public Long llen(String key) {
		if (adapter != null) {
			return adapter.doLlen(key);
		}
		return 0L;
	}

	public String getClusters() {
		return clusters;
	}

	public void setClusters(String clusters) {
		this.clusters = clusters;
	}
}

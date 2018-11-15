package com.bdxh.kmsale.cache.redis;

import java.util.Set;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterExt extends JedisCluster implements RedisAdapter {


	public JedisClusterExt(Set<HostAndPort> nodes) {
		super(nodes);
	}

	@Override
	public String doGet(String key) {
		return get(key);
	}

	@Override
	public void doSet(String key, String value) {
		set(key, value);
	}

	@Override
	public void doSetex(String key, int seconds, String value) {
		setex(key, seconds, value);
	}
	
	@Override
	public Long doSetnx(String key, String value) {
		return setnx(key, value);
	}
	
	@Override
	public String getSet(String key , String value) {
		return getSet(key, value);
	}
	
	@Override
	public Long doDel(String key) {
		return del(key);
	}

	@Override
	public Long doLlen(String key) {
		return llen(key);
	}

}

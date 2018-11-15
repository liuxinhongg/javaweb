package com.bdxh.kmsale.cache.redis;

import redis.clients.jedis.Jedis;

public class JedisExt extends Jedis implements RedisAdapter {

	public JedisExt(String host, int port) {
		super(host, port);
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

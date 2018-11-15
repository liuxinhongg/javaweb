package com.bdxh.kmsale.cache.redis;


interface RedisAdapter {

	String doGet(final String key);

	void doSet(final String key, final String value);

	void doSetex(String key, int seconds, final String value);

	Long doSetnx(String key , final String value);
	
	String getSet(String key , final String value);
	
	Long doDel(final String key);

	Long doLlen(String key);
}

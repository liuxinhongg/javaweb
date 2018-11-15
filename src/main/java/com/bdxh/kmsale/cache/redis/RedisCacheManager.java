package com.bdxh.kmsale.cache.redis;

import java.util.Collection;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import com.bdxh.kmsale.utils.ObjectSerialize;
import com.bdxh.kmsale.utils.Md5Utils;


public class RedisCacheManager implements CacheManager {

	protected RedisTemplate redisTemplate = RedisTemplate.getInstance();

	private Integer defaultExpiredTime = 1 * 60 * 30; // 30 minute

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new CacheImpl<K, V>(redisTemplate, defaultExpiredTime);
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public Integer getExpiredTime() {
		return defaultExpiredTime;
	}

	public void setExpiredTime(Integer expiredTime) {
		this.defaultExpiredTime = expiredTime;
	}

	static class CacheImpl<K, V> implements Cache<K, V> {

		private RedisTemplate redisTemplate;
		private Integer expiredTime;

		public CacheImpl(RedisTemplate redisTemplate, Integer expiredTime) {
			this.redisTemplate = redisTemplate;
			this.expiredTime = expiredTime;
		}

		private String getKey(K key) {
			if (key instanceof SimplePrincipalCollection) {
				return key.toString();
			}
			return Md5Utils.hash(ObjectSerialize.serialization(key));
		}

		@SuppressWarnings("unchecked")
		@Override
		public V get(K key) throws CacheException {
			String serial = redisTemplate.get(getKey(key));
			if (StringUtils.isNotBlank(serial)) {
				return (V) ObjectSerialize.deserialization(serial);
			}
			return null;
		}

		@Override
		public V put(K key, V value) throws CacheException {
			String k = getKey(key);
			redisTemplate.setex(k, ObjectSerialize.serialization(value), expiredTime);
			return value;
		}

		@Override
		public V remove(K key) throws CacheException {
			String k = getKey(key);
			V v = get(key);
			redisTemplate.del(k);
			return v;
		}

		@Override
		public void clear() throws CacheException {
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public Set<K> keys() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<V> values() {
			// TODO Auto-generated method stub
			return null;
		}

    }
}
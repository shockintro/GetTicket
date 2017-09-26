package com.lhf.ticket.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis数据源工具类
 * 
 * @author lihf
 * @date 2017年9月6日
 */
public class RedisCachePool {

	private static JedisPool jedisPool = null;


	/**
	 * 初始化Redis连接池
	 * 
	 * @param redisHost
	 * @param port
	 */
	public static JedisPool getRedisPool(String configHost,Integer configPort) {
		if (jedisPool == null) {
			jedisPool = new JedisPool(new JedisPoolConfig(), configHost, configPort);
		}
		return jedisPool;
	}

	/**
	 * 返回Redis数据源操作对象，指定Redis库
	 * 
	 * @param database
	 * @return
	 */
	public static Jedis getResource(Integer database) {
		Jedis jedisInstance = null;
		if (jedisPool != null) {
			jedisInstance = jedisPool.getResource();
			if (database > 0) {// 每次获得连接之前，切换到对应的数据库。默认的是0
				jedisInstance.select(database);
			}
		}
		return jedisInstance;
	}

	/**
	 * 释放Redis资源
	 * 
	 * @param Jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			// jedisPool.returnResource(jedis);
			jedis.close();
		}
	}

	/**
	 * 返回Redis数据源操作对象，默认Redis 0 号库
	 * 
	 * @param database
	 * @return
	 */
	public static Jedis getResource() {
		Jedis jedisInstance = null;
		if (jedisPool != null) {
			jedisInstance = jedisPool.getResource();
		}
		return jedisInstance;
	}
}

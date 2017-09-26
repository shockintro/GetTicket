package com.lhf.ticket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetTicketApplicationTests {

	@Test
	public void contextLoads() {
	}
	public static void main(String[] args) {
//		//Jedis数据连接源配置
//		JedisPool jedisPool = RedisCachePool.getRedisPool("172.16.1.216", 6379);
//		// 获取Jedis连接源对象
//		Jedis jedis = jedisPool.getResource();
//		jedis.set("a", "123");
//		System.out.println(jedis.get("a"));
		for (int i = 1; i <= 81; i++) {
//			for (int j = 1; j <= 9; j++) {
				System.out.println(i);
//			}
//			System.out.println(i);
		}
	}
}

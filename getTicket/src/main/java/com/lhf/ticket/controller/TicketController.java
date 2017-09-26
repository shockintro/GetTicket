package com.lhf.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.ticket.model.OrderItem;
import com.lhf.ticket.model.ResponseModel;
import com.lhf.ticket.service.TicketService;
import com.lhf.ticket.util.RedisCachePool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @author lihf
 *
 */

@RestController
@RequestMapping(value = "/api/ticket")
public class TicketController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static JedisPool jedisPool;
	
	//这种初始化方式很不规范 不过就目前的功能而言 方便
	{
		jedisPool = RedisCachePool.getRedisPool("172.16.1.216", 6379);
	}
	
	
	@Autowired 
	private TicketService ticketService;
	
	@GetMapping()
	public ResponseModel getAll() {
		JSONObject orderList = new JSONObject();
		orderList.put("data", ticketService.getDetail());
		return  new ResponseModel.Builder().result(orderList).build();
	}
	
	@PostMapping()
	public ResponseModel getTicket(@RequestBody  OrderItem orderIntem) {
		System.out.println("api/ticket");
		return null;
	}
//	// 初始化redis连接池
//			JedisPool jedisPool = RedisCachePool.getRedisPool(configHost, configPort);
//			// 获取Jedis连接源对象
//			Jedis jedis = jedisPool.getResource();
}

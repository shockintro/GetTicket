package com.lhf.ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.ticket.model.OrderItem;
import com.lhf.ticket.model.ResponseModel;
import com.lhf.ticket.service.TicketService;
import com.lhf.ticket.util.RedisCachePool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import net.sf.json.JSONObject;


/**订票模块
 * @author lihf
 */

@RestController
@RequestMapping(value = "/api/ticket")
public class TicketController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private static JedisPool jedisPool;

	private static Jedis jedis;

	// 这种初始化方式很不规范 不过就目前的功能而言 方便
	{
		jedisPool = RedisCachePool.getRedisPool("172.16.1.216", 6379);
	}

	@Autowired
	private TicketService ticketService;//目前用不到 先放着 万一以后有用

	/**
	 * 获取当前预订信息
	 */
	@GetMapping()
	public ResponseModel getAll() {
		jedis = jedisPool.getResource();//jedis初始化
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 81; i++) {//遍历座位被预订情况
			if(jedis.getbit("sit",i)) {
				list.add(i+1);//被预定的座位id加入list对象
			}
		}
		
		JSONObject orderList = new JSONObject();
		orderList.put("data",list);
		
		return  new ResponseModel.Builder().result(orderList).build();
	}

	/**	订票
	 * @param orderIntem
	 */
	@PostMapping()
	public ResponseModel getTicket(@RequestBody OrderItem orderIntem) {
		jedis = jedisPool.getResource();
		String[] sits = orderIntem.getSelected().split(",");
		for (String string : sits) {
			jedis.setbit("sit", Integer.valueOf(string)-1, "1");//被预定的座位 将sit对应的位置1
		}
		return new ResponseModel.Builder().result(jedis.bitcount("sit")).build();
	}

}

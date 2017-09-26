package com.lhf.ticket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhf.ticket.dao.TicketDao;
import com.lhf.ticket.model.OrderItem;
import com.lhf.ticket.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDao ticketDao;

	@Override
	public List<OrderItem> getDetail() {
		// TODO Auto-generated method stub
		return ticketDao.getDetail();
	}
	
}

package com.lhf.ticket.dao;

import java.util.List;

import com.lhf.ticket.model.OrderItem;

public interface TicketDao {

	List<OrderItem> getDetail();

}

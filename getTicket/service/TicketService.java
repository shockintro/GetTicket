package com.lhf.ticket.service;

import java.util.List;


import com.lhf.ticket.model.OrderItem;

public interface TicketService {
	List<OrderItem> getDetail();
}

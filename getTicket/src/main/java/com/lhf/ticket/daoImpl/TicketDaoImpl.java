package com.lhf.ticket.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhf.ticket.dao.TicketDao;
import com.lhf.ticket.model.OrderItem;
@Repository
public class TicketDaoImpl extends BaseDaoImpl<Object, Integer> implements TicketDao {
	private static final String GET_ALL = "getAll";
	@Override
	public List<OrderItem> getDetail() {
		return this.getSqlSession().selectList(GET_ALL);
	}

}

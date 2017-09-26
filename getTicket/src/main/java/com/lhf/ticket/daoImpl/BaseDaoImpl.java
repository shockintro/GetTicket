package com.lhf.ticket.daoImpl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.lhf.ticket.dao.BaseDao;

public class BaseDaoImpl<T, ID> extends SqlSessionDaoSupport implements BaseDao<T, ID> {
	@Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
    }
}

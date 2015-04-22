package com.rakuten.stock.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.stock.dao.StockDao;
import com.rakuten.stock.model.Stock;

@Repository("stockDao")
public class StockDaoImpl implements StockDao{
	@Autowired
	SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Stock stock) {
		currentSession().save(stock);
		
	}

	public void update(Stock stock)
	{
		
		currentSession().update(stock);
		
	}

	public void delete(Stock stock) {
		currentSession().delete(stock);
		
	}

	public Stock findByStockCode(String stockCode) 
	{
		Stock s = null;
		
		Criteria criteria = currentSession().createCriteria(Stock.class);
        criteria.add(Restrictions.eq("stockCode",stockCode));
        s = (Stock) criteria.uniqueResult();
        return s;
	}
}

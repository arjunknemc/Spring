package com.rakuten.stock.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.stock.bo.StockBo;
import com.rakuten.stock.dao.StockDao;
import com.rakuten.stock.model.Stock;

@Service("stockBo")
@Transactional
public class StockBoImpl implements StockBo{
	@Autowired
	StockDao stockDao;
	
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public void save(Stock stock) {
		stockDao.save(stock);
		
	}

	public void update(Stock stock) {
		stockDao.update(stock);
		
	}

	public void delete(Stock stock) {
		stockDao.delete(stock);
		
	}


	public Stock findByStockCode(String stockCode) {
		return stockDao.findByStockCode(stockCode);
	}
	
	

}

package com.rakuten.stock.dao;

import com.rakuten.stock.model.Stock;

public interface StockDao {
	
	public void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}

package com.rakuten.stock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOCK")
public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID")
	private Long stockId;
	
	@Column(name = "STOCK_CODE", unique = true, nullable = false)
	private String stockCode;
	
	@Column(name = "STOCK_NAME", unique = true, nullable = false)
	private String stockName;

	//getter and setter methods
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockCode=" + stockCode
				+ ", stockName=" + stockName + "]";
	}
	
	
}

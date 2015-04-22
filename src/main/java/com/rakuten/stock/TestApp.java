package com.rakuten.stock;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.stock.bo.StockBo;
import com.rakuten.stock.config.AppConfig;
import com.rakuten.stock.model.Stock;


public class TestApp {

	public static void main(String [] args) 
	{
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		StockBo stockBo = (StockBo)appContext.getBean("stockBo");

		System.out.println("Enter the operations to be performed");
		System.out.println("1. Insert Operation");
		System.out.println("2. Update Operation");
		System.out.println("3. Delete Operation");

		Scanner sc = new Scanner(System.in);
		int option=sc.nextInt();

		switch(option)
		{
		case 1: 
			Stock stock = new Stock();

			stock.setStockCode("7668");
			stock.setStockName("HAIO");
			stockBo.save(stock);
			break;

		case 2 :
			Stock stock2 = stockBo.findByStockCode("7669");
			if(stock2==null)
			{
				System.out.println("Stock with the Request Code does not exist..");
			}
			else
			{
				stock2.setStockName("HAIO-1");
				stockBo.update(stock2);
			}
			break;

		case 3 : 
			Stock stock3 = stockBo.findByStockCode("7668");

			if(stock3==null)
			{
				System.out.println("Stock with the Request Code does not exist..");
			}
			else
			{
				stock3.setStockName("HAIO-1");
				stockBo.delete(stock3);
			}

			break;
		}



	}

}
;
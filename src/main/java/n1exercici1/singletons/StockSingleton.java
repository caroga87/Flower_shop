package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

import n1exercici1.beans.Product;


public class StockSingleton {
	
private static StockSingleton stockSingleton;
	
	private List<Product> stockList;
	
	private StockSingleton() {
		super();
		stockList = new ArrayList<>();
	}
	
	public static StockSingleton getStockSingleton() {
		if(stockSingleton == null) {
			stockSingleton = new StockSingleton();
		}
		return stockSingleton;
	}

	public List<Product> getStockList() {
		return stockList;
	}

	public void setStockList(List<Product> stockList) {
		this.stockList = stockList;
	}

	@Override
	public String toString() {
		return "StockSingleton [stockList=" + stockList + "]";
	}	
}

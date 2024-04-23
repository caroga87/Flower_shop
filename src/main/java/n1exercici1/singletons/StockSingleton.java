package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

import n1exercici1.beans.Product;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.io.FlowerShopFileWriter;
import n1exercici1.utils.Constants;


public class StockSingleton {
	
	private static StockSingleton stockSingleton;
	
	private int maxAssignedProductId;
	private static int nextProductId;
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
	
	public int getNextProductId() {
		this.maxAssignedProductId = nextProductId;
		nextProductId++;
		return maxAssignedProductId;
	}
	
	//assigned from file read
	public void setNextProductId(int readMaxAssignedProductId) {
		nextProductId = readMaxAssignedProductId;
		nextProductId++;
	}

	public List<Product> getStockList() {
		return stockList;
	}

	public void setStockList(List<Product> stockList) {
		this.stockList = stockList;
	}
	
	public void loadStock() {
		FlowerShopFileReader.readStockFile(Constants.Files.STOCK);		
	}
	
	public void handleMaxAssignedProducIdPersitence() {
		
		if(!FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			FileManager.createFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS);
		}
		
		FlowerShopFileWriter.writeIdToFile("product:" + maxAssignedProductId + "\n", Constants.Files.IDS);
		
	}
	
	public void handleStockPersistence() {
		
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK, true);
		
		if(stockList.isEmpty()) {
			FileManager.createFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK);
		} else {
			for(int i = 0; i < stockList.size(); i++) {
				if(stockList.size() == 1) {
					FlowerShopFileWriter.writeToJsonFile(stockList.get(i), Constants.Files.STOCK, true, true);
				} else if(i == 0 && stockList.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(stockList.get(i), Constants.Files.STOCK, true, false);
				} else if(i == stockList.size() - 1 && stockList.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(stockList.get(i), Constants.Files.STOCK, false, true);
				} else {
					FlowerShopFileWriter.writeToJsonFile(stockList.get(i), Constants.Files.STOCK, false, false);
				}
			}
		}
		
	}

}

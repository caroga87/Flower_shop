package n2MySQL.singletons;

import n2MySQL.beans.FlowerShop;
import n2MySQL.io.FileManager;
import n2MySQL.io.FlowerShopFileReader;
import n2MySQL.io.FlowerShopFileWriter;
import n2MySQL.utis.Constants;

public class FlowerShopSingleton {

private static FlowerShopSingleton flowerShopSingleton;
	
	private FlowerShop flowerShop;
	
	private FlowerShopSingleton() {
		super();
	}
	
	public static FlowerShopSingleton getFlowerShopSingleton() {
		if(flowerShopSingleton == null) {
			flowerShopSingleton = new FlowerShopSingleton();
		}
		return flowerShopSingleton;
	}

	public FlowerShop getFlowerShop() {
		return flowerShop;
	}

	public void setFlowerShop(FlowerShop flowerShop) {
		this.flowerShop = flowerShop;
	}
	
	public void loadFlowerShop() {
		FlowerShopFileReader.readFlowerShopFile(Constants.Files.FLOWER_SHOP);		
	}
	
	public void handleFlowerShopPersistance() {
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP, true);
		FlowerShopFileWriter.writeToJsonFile(flowerShop, Constants.Files.FLOWER_SHOP, true, true);
	}

}

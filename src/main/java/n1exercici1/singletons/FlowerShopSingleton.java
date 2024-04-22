package n1exercici1.singletons;


import n1exercici1.beans.FlowerShop;

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
	
}

package n2MySQL.beans;

import n2MySQL.singletons.StockSingleton;

public abstract class Product  {
	
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String name;
	private double sellPrice;
	private double costPrice;
	private int stock;
	
	//important for json deserialization
	public Product() {
		super();
	}
	
	public Product(String name, double sellPrice, double costPrice, int stock) {
		super();
		this.productId = StockSingleton.getStockSingleton().getNextProductId();
		this.name = name;
		this.sellPrice = sellPrice;
		this.costPrice = costPrice;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public int getProductId() {
		return productId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId
							+ ", name=" + name 
							+ ", sellPrice=" + sellPrice
							+ ", costPrice=" + costPrice 
							+ ", stock=" + stock
							+ ", ";
	}
	
	public String toStock() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(productId).append(" >>> ")
			.append(stock).append(" x ")
			.append(name).append(", ")
			.append(costPrice).append(" eur./unit, ")
			.append(costPrice * stock).append(" eur.");
		
		return sb.toString();
		
	}
	
	public abstract String toCatalogue();
	
}

	
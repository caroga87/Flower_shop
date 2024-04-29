package n2MySQL.beans;

public class FlowerShop{

	private String name;
	private double totalEarnings;
	private double totalStockValue;
	public FlowerShop() {
		super();
	}
	
	public FlowerShop(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public double getTotalStockValue() {
		return totalStockValue;
	}

	public void setTotalStockValue(double totalStockValue) {
		this.totalStockValue = totalStockValue;
	}

	@Override
	public String toString() {
		return "FlowerShop [name=" + name 
								+ ", totalEarnings=" + totalEarnings 
								+ ", totalStockValue=" + totalStockValue + "]";
	}

}

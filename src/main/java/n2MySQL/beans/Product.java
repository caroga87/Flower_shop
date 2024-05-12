package n2MySQL.beans;

public abstract class Product <T> {

	private int product_id;
	private String name;
	private double sellPrice;
	private double costPrice;
	private int stock;
	private ProductType productType;
	private T attribute;


	public Product(String name, double sellPrice, double costPrice, int stock, ProductType productType, T attribute) {
		this.name = name;
		this.sellPrice = sellPrice;
		this.costPrice = costPrice;
		this.stock = stock;
		this.productType = productType;
		this.attribute = attribute;
	}

	public Product(int product_id, String name, double sellPrice, double costPrice, int stock,  ProductType productType, T attribute) {
		this.product_id = product_id;
		this.name = name;
		this.sellPrice = sellPrice;
		this.costPrice = costPrice;
		this.stock = stock;
		this.productType = productType;
		this.attribute = attribute;
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

	public T getAttribute() {
		return attribute;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public void setAttribute(T attribute) {
		this.attribute = attribute;
	}

	public int getProductId() {
		return product_id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + product_id
				+ ", name=" + name
				+ ", sellPrice=" + sellPrice
				+ ", costPrice=" + costPrice
				+ ", stock=" + stock
				+ ", ";
	}

	public String toStock() {

		StringBuilder sb = new StringBuilder();

		sb.append(product_id).append(" >>> ")
				.append(stock).append(" x ")
				.append(name).append(", ")
				.append(costPrice).append(" eur./unit, ")
				.append(costPrice * stock).append(" eur.");

		return sb.toString();

	}

	public abstract String toCatalogue();

}

	
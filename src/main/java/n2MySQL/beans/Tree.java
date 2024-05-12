package n2MySQL.beans;


import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.handlers.AppHandler;

public class Tree <T> extends Product <T>{
	private T height;


	public Tree(String name, double sellPrice, double costPrice, int stock, T height) {
		super(name, sellPrice, costPrice, stock, ProductType.TREE, height);
		this.height = height;
	}

	public Tree(int product_id, String name, double sellPrice, double costPrice, int stock, T height) {
		super(product_id, name, sellPrice, costPrice, stock, ProductType.TREE, height);
		this.height = height;
	}

	public T getHeight() {
		return height;
	}

	public void setHeight(T height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + "Tree [height=" + height + "]]";
	}

	@Override
	public String toCatalogue() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.getProductId()).append(" >>> ")
				.append(super.getName()).append(", ")
				.append(super.getSellPrice()).append(" eur./unit, ")
				.append(height).append("cm");

		return sb.toString();

	}

	@Override
	public String toStock() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.getProductId()).append(" >>> ")
				.append(super.getStock()).append(" x ")
				.append(super.getName()).append(", ")
				.append(super.getCostPrice()).append(" eur./unit, ")
				.append(super.getCostPrice() * super.getStock()).append(" eur.");

		return sb.toString();

	}

}
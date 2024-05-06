package n2MySQL.beans;


import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.interfaces.ISpecificProduct;
import n2MySQL.handlers.AppHandler;

public class Tree extends Product implements ISpecificProduct{
	private int height;

	public Tree(String name, double sellPrice, double costPrice, int stock, int height) {
		super(name, sellPrice, costPrice, stock);
		this.height = height;
	}

	public Tree(int product_id, String name, double sellPrice, double costPrice, int stock, int height) {
		super(product_id, name, sellPrice, costPrice, stock);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void printProductType() {
		AppHandler.printText(ProductTypeEnum.TREE.getType());
	}

	@Override
	public String toString() {
		return super.toString() + "Tree [height=" + height + "]]";
	}

	@Override
	public String toCatalogue() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProduct_id()).append(" >>> ")
			.append(super.getName()).append(", ")
			.append(super.getSellPrice()).append(" eur./unit, ")
			.append(height).append("cm");
		
		return sb.toString();
		
	}

	@Override
	public String toStock() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProduct_id()).append(" >>> ")
			.append(super.getStock()).append(" x ")
			.append(super.getName()).append(", ")
			.append(super.getCostPrice()).append(" eur./unit, ")
			.append(super.getCostPrice() * super.getStock()).append(" eur.");
		
		return sb.toString();
		
	}

}

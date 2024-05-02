package n2MySQL.beans;


import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.interfaces.ISpecificProduct;
import n2MySQL.handlers.AppHandler;

public class Flower extends Product implements ISpecificProduct {

	private String colour;
	public Flower(String name, double sellPrice, double costPrice, int stock, String colour) {
		super(name, sellPrice, costPrice, stock);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public void printProductType() {
		AppHandler.printText(ProductTypeEnum.FLOWER.getType());
	}

	@Override
	public String toString() {
		return super.toString() + "Flower [colour=" + colour + "]]";
	}

	@Override
	public String toCatalogue() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProduct_id()).append(" >>> ").append(super.getName()).append(", ").append(super.getSellPrice()).append(" eur., ").append(colour);
		
		return sb.toString();
		
	}

}

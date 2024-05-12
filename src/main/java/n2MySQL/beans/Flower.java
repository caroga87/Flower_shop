package n2MySQL.beans;


import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.handlers.AppHandler;

public class Flower<T> extends Product <T> {
	private  T colour;

	public Flower(String name, double sellPrice, double costPrice, int stock, T colour) {
		super(name, sellPrice, costPrice, stock, ProductType.FLOWER, colour);
		this.colour = colour;
	}

	public Flower(int product_id, String name, double sellPrice, double costPrice, int stock, T colour) {
		super(product_id, name, sellPrice, costPrice, stock, ProductType.FLOWER, colour);
		this.colour = colour;
	}

	public T getColour() {
		return colour;
	}

	public void setColour(T colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return super.toString() + "Flower [colour=" + colour + "]]";
	}

	@Override
	public String toCatalogue() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.getProductId()).append(" >>> ").append(super.getName()).append(", ").append(super.getSellPrice()).append(" eur., ").append(colour);

		return sb.toString();

	}

}
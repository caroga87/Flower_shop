package n2MySQL.beans;

import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.handlers.AppHandler;

public class Decoration <T> extends Product <T>{

	private T material;

	public Decoration(String name, double sellPrice, double costPrice, int stock, T material) {
		super(name, sellPrice, costPrice, stock, ProductType.DECORATION, material);
		this.material = material;
	}

	public Decoration(int product_id, String name, double sellPrice, double costPrice, int stock, T material) {
		super(product_id, name, sellPrice, costPrice, stock, ProductType.DECORATION, material);
		this.material = material;
	}

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}


	@Override
	public String toString() {
		return super.toString() + "Decoration [material=" + material + "]]";
	}

	@Override
	public String toCatalogue() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.getProductId()).append(" >>> ").append(super.getName()).append(", ").append(super.getSellPrice()).append(" eur., ").append(material);

		return sb.toString();

	}



}
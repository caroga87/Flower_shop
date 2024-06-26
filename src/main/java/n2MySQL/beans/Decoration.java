package n2MySQL.beans;

import n2MySQL.enums.ProductTypeEnum;
import n2MySQL.interfaces.ISpecificProduct;
import n2MySQL.handlers.AppHandler;

public class Decoration extends Product implements ISpecificProduct {
	private String material;
	
	//important for json deserialization
	public Decoration() {
		super();
	}
	
	public Decoration(String name, double sellPrice, double costPrice, int stock, String material) {
		super(name, sellPrice, costPrice, stock);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void printProductType() {
		AppHandler.printText(ProductTypeEnum.DECORATION.getType());
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

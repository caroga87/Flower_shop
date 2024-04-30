package n2MySQL.factories;


import n2MySQL.beans.Decoration;
import n2MySQL.interfaces.ISpecificProduct;

public class DecorationFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(int product_id, String name, double sellPrice, double costPrice, int stock, String other) {
		return new Decoration(product_id,name, sellPrice, costPrice, stock, other);
	}
}

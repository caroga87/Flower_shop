package n2MySQL.factories;


import n2MySQL.beans.Decoration;
import n2MySQL.interfaces.ISpecificProduct;

public class DecorationFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Decoration(name, sellPrice, costPrice, stock, other);
	}
}

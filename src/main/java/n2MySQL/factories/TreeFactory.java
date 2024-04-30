package n2MySQL.factories;

import n2MySQL.beans.Tree;
import n2MySQL.interfaces.ISpecificProduct;

public class TreeFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(int product_id,String name, double sellPrice, double costPrice, int stock, String other) {
		return new Tree(product_id,name, sellPrice, costPrice, stock, Integer.parseInt(other));
	}
}

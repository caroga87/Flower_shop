package n2MySQL.factories;

import n2MySQL.beans.Tree;

public class TreeFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Tree(name, sellPrice, costPrice, stock, Integer.parseInt(other));
	}
}

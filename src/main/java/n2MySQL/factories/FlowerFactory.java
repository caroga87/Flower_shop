package n2MySQL.factories;

import n2MySQL.beans.Flower;

public class FlowerFactory extends ProductAbstractFactory {

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Flower(name, sellPrice, costPrice, stock, other);
	}
}

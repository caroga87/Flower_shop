package n2MySQL.factories;

import n2MySQL.beans.Flower;
import n2MySQL.interfaces.ISpecificProduct;

public class FlowerFactory extends ProductAbstractFactory {

	@Override
	public ISpecificProduct createSpecificProduct(int product_id,String name, double sellPrice, double costPrice, int stock, String other) {
		return new Flower(product_id,name, sellPrice, costPrice, stock, other);
	}
}

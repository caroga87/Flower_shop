package n2MySQL.factories;

import n2MySQL.interfaces.ISpecificProduct;

public abstract class ProductAbstractFactory {

	public abstract ISpecificProduct createSpecificProduct(int product_id,String name, double sellPrice, double costPrice, int stock, String other);
}

package n2MySQL.factories;

public abstract class ProductAbstractFactory {

	public abstract ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other);
}

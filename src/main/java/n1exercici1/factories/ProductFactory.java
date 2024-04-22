package n1exercici1.factories;

import n1exercici1.beans.Decoration;
import n1exercici1.beans.Flower;
import n1exercici1.beans.Product;
import n1exercici1.beans.Tree;
import n1exercici1.exceptions.IllegalArgumentFactoryException;
import n1exercici1.utils.Constants;

public class ProductFactory {
	    
	public static Product createProduct(String type, String name, String priceCost, String priceSale, String stock, String attribute) throws IllegalArgumentFactoryException {
        
		switch (type.toLowerCase()) {
	    	case "1":
	    		return new Tree(name, priceCost, priceSale, stock, attribute);
	        case "2":
	            return new Flower(name, priceCost, priceSale, stock, attribute);
	        case "3":
	            return new Decoration(name, priceCost, priceSale, stock, attribute);
	        default:
	            throw new IllegalArgumentFactoryException(Constants.Exceptions.TYPE);
		}
	}
}

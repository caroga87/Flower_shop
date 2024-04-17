package n1exercici1.factories;

import n1exercici1.beans.Decoration;
import n1exercici1.beans.Flower;
import n1exercici1.beans.Product;
import n1exercici1.beans.Tree;
import n1exercici1.utils.Constants;

public class ProductFactory {
	    
	public static Product createProduct(String type, String name, double price, int stock) {
        
		switch (type.toLowerCase()) {
	    	case "tree":
	    		return new Tree(name, price, stock);
	        case "flower":
	            return new Flower(name, price, stock);
	        case "decoration":
	            return new Decoration(name, price, stock);
	        default:
	            throw new IllegalArgumentException(Constants.Exceptions.TYPE + type);
		}
	}
}

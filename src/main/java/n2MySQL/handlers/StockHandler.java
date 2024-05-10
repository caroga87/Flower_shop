package n2MySQL.handlers;

import n2MySQL.beans.Decoration;
import n2MySQL.beans.Flower;
import n2MySQL.beans.Product;
import n2MySQL.beans.Tree;
import n2MySQL.factories.DecorationFactory;
import n2MySQL.factories.FlowerFactory;
import n2MySQL.factories.TreeFactory;
import n2MySQL.utils.Constants;
import n2MySQL.utils.Validations;



import java.util.ArrayList;
import java.util.List;


public class StockHandler {

	
	public static void createTree(String name, double sellPrice, double costPrice, int stock, String height) {

		TreeFactory factory = new TreeFactory();
		Tree tree = (Tree) factory.createSpecificProduct(name, sellPrice, costPrice, stock, height);

		StockSingleton.getStockSingleton().getStock().add(tree); // quan ho guarda al singleton -> canviar-la al sql

		recalculateTotalStockValueOnAdd(tree.getStock(), tree.getCostPrice());// mirar si aquest metode és necessari

		

	}

	public static void createFlower(String name, double sellPrice, double costPrice, int stock, String colour) {

		FlowerFactory factory = new FlowerFactory();
		Flower flower = (Flower) factory.createSpecificProduct(name, sellPrice, costPrice, stock, colour);
		
		StockSingleton.getStockSingleton().getStock().add(flower);

		recalculateTotalStockValueOnAdd(flower.getStock(), flower.getCostPrice());

	}

	public static void createDecoration(String name, double sellPrice, double costPrice, int stock, String material) {

		DecorationFactory factory = new DecorationFactory();
		Decoration decoration = (Decoration) factory.createSpecificProduct(name, sellPrice, costPrice, stock, material);

		StockSingleton.getStockSingleton().getStock().add(decoration);

		recalculateTotalStockValueOnAdd(decoration.getStock(), decoration.getCostPrice());


	}

	public static void showCatalogue() { // nom + caracteristica + preu venda +id

		List<Tree> trees = new ArrayList<>();
		List<Flower> flowers = new ArrayList<>();
		List<Decoration> decorations = new ArrayList<>();

		for(Product product : StockSingleton.getStockSingleton().getStock()) {
			if(product instanceof Tree) {
				trees.add((Tree) product);
			} else if(product instanceof Flower) {
				flowers.add((Flower) product);
			} else if(product instanceof Decoration) {
				decorations.add((Decoration) product);
			}
		}

		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toCatalogue());});

		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toCatalogue());});

		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toCatalogue());});

	}

	public static void showStock() { // nom + caracteristica + preu cost +id

		List<Tree> trees = new ArrayList<>();
		List<Flower> flowers = new ArrayList<>();
		List<Decoration> decorations = new ArrayList<>();

		for(Product product : StockSingleton.getStockSingleton().getStock()) {
			if(product instanceof Tree) {
				trees.add((Tree) product);
			} else if(product instanceof Flower) {
				flowers.add((Flower) product);
			} else if(product instanceof Decoration) {
				decorations.add((Decoration) product);
			}
		}

		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toStock());});

		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toStock());});

		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toStock());});

	}

	public static String getTotalStockValue() { //

		StringBuilder sb = new StringBuilder();

		sb.append(Constants.Menus.STOCK_VALUE);
		sb.append(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue());
		sb.append(" eur.\n");

		return sb.toString();

	}

	public static void runAddProductsToStock() {

		String productName = "";
		do {

			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			productName = AppHandler.readConsoleInput().trim();

		} while(!Validations.isValidProductName(productName));

		Product product = findProductByName(productName);
		if(product != null) {

			String stockToBeAdded = "";
			do {

				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stockToBeAdded = AppHandler.readConsoleInput().trim();

				product.setStock(Integer.parseInt(stockToBeAdded) + product.getStock());
				recalculateTotalStockValueOnAdd(Integer.parseInt(stockToBeAdded), product.getCostPrice());
				AppHandler.printText(Constants.Menus.STOCK_UPDATE);

			} while(!Validations.isNaturalNumber(stockToBeAdded));

		}else {
			AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
		}
	}

	public static Product findProductByName(String name) {

		Product product = null;

		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.getName().equalsIgnoreCase(name)) {
				product = prod;
				break;
			}
		}

		return product;

	}

	public static Product findProductByProductId(int productId) {

		Product product = null;

		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.productId() == productId) {
				product = prod;
				break;
			}
		}

		return product;

	}

	public static boolean removeProductByProductId(int productId) {

		boolean deleted = false;

		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.productId() == productId) {
				recalculateTotalStockValueOnDelete(prod.getStock(), prod.getCostPrice());
				StockSingleton.getStockSingleton().getStock().remove(prod);
				deleted = true;
				break;
			}
		}

		return deleted;

	}

	public static boolean thereIsEnoughStock(Product product, int quantity) {
		return (product.getStock() - quantity) >= 0;
	}

	public static void deductStock(Product product, int quantity) {

		product.setStock(product.getStock() - quantity);
		recalculateTotalStockValueOnDelete(quantity, product.getCostPrice());

	}

	public static void putBackInStock(Product product, int quantity) {

		product.setStock(product.getStock() + quantity);
		recalculateTotalStockValueOnAdd(quantity, product.getCostPrice());

	}

	private static void recalculateTotalStockValueOnAdd(int quantity, double unitPrice) {

		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue() + (quantity * unitPrice);
		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalStockValue(newTotal);

	}

	private static void recalculateTotalStockValueOnDelete(int quantity, double unitPrice) {

		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue() - (quantity * unitPrice);
		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalStockValue(newTotal);

	}

	public static void runViewCatalogue() {

		
		StockHandler.showCatalogue();

	}

	public static void runViewStockValue() {

		
		AppHandler.printText(StockHandler.getTotalStockValue());

	}


	public static void runViewStock() {

		
		StockHandler.showStock();

	}



}

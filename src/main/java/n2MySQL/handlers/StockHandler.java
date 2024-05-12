package n2MySQL.handlers;

import n2MySQL.MySQLdatabase.queries.ProductSQL;
import n2MySQL.beans.Decoration;
import n2MySQL.beans.Flower;
import n2MySQL.beans.Product;
import n2MySQL.beans.Tree;
import n2MySQL.utils.Constants;
import n2MySQL.utils.Validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class StockHandler {

	private static Logger logger = LoggerFactory.getLogger(StockHandler.class);
	private static ProductSQL productSQL;

	public static void createTree(String name, double sellPrice, double costPrice, int stock, String height) {
		productSQL.create(new Tree(name, sellPrice, costPrice, stock, height));
		logger.info("StockHandler :: createTree :: New tree created.");

	}

	public static void createFlower(String name, double sellPrice, double costPrice, int stock, String colour) {
		productSQL.create(new Flower(name, sellPrice, costPrice, stock, colour));
		logger.info("StockHandler :: createFlower :: New flower created.");

	}

	public static void createDecoration(String name, double sellPrice, double costPrice, int stock, String material) {
		productSQL.create(new Decoration(name, sellPrice, costPrice, stock, material));
		logger.info("StockHandler :: createDecoration :: New decoration created.");

	}

	public static void showCatalogue() { // nom + caracteristica + preu venda +id
		List<Product> products = productSQL.readAll();
		products.forEach(product -> AppHandler.printText(product.toCatalogue()));

	}

	public static void showStock() { // nom + caracteristica + preu cost +id
		List<Product> products = productSQL.readAll();
		products.forEach(product -> AppHandler.printText(product.toStock()));

	}

	public static String getTotalStockValue() {
		double totalStockValue = calculateTotalStockValue();
		return Constants.Menus.STOCK_VALUE + totalStockValue + " eur.\n";

	}
	public static double calculateTotalStockValue() {
		double totalValue = 0.0;

		List<Product> products = productSQL.readAll();
		for (Product product : products) {
			totalValue += product.getStock() * product.getCostPrice();
		}

		return totalValue;
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
				AppHandler.printText(Constants.Menus.STOCK_UPDATE);

			} while(!Validations.isNaturalNumber(stockToBeAdded));

		}else {
			AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
		}
	}

	public static Product findProductByName(String name) {
		Product product = productSQL.getOneByName(name);
		return product;
	}

	public static Product findProductByProductId(int productId) {
		return productSQL.getOne(productId);
	}

	public static boolean removeProductByProductName(String name) {
		Product product = productSQL.getOneByName(name);
		if (product != null) {
			productSQL.delete(product);
			return true;
		}
		return false;
	}



	public static boolean thereIsEnoughStock(Product product, int quantity) {
		return (product.getStock() - quantity) >= 0;
	}

	public static void deductStock(Product product, int quantity) {

		product.setStock(product.getStock() - quantity);
		}

	public static void putBackInStock(Product product, int quantity) {

		product.setStock(product.getStock() + quantity);


	}

	public static void runViewCatalogue() {

		logger.info("StockHandler :: runViewCatalogue :: About to display all the products.");
		StockHandler.showCatalogue();

	}

	public static void runViewStockValue() {

		logger.info("StockHandler :: runViewStockValue :: About to display the total stock value.");
		AppHandler.printText(StockHandler.getTotalStockValue());

	}


	public static void runViewStock() {

		logger.info("StockHandler :: runViewStock :: About to display the total stock of the shop.");
		StockHandler.showStock();

	}



}

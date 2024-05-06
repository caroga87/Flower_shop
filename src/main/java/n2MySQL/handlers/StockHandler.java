package n2MySQL.handlers;

import n2MySQL.DAO.DecorationDAO;
import n2MySQL.DAO.FlowerDAO;
import n2MySQL.DAO.TreeDAO;
import n2MySQL.beans.Decoration;
import n2MySQL.beans.Flower;
import n2MySQL.beans.Product;
import n2MySQL.beans.Tree;
import n2MySQL.factories.DecorationFactory;
import n2MySQL.factories.FlowerFactory;
import n2MySQL.factories.TreeFactory;
import n2MySQL.utils.Constants;
import n2MySQL.utils.Validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class StockHandler {

	private static Logger logger = LoggerFactory.getLogger(StockHandler.class);
	private static FlowerDAO flowerDAO;
	private static TreeDAO treeDAO;
	private static DecorationDAO decorationDAO;

	public static void createTree(String name, double sellPrice, double costPrice, int stock, String height) {

		TreeFactory factory = new TreeFactory();
		Tree tree = (Tree) factory.createSpecificProduct(name, sellPrice, costPrice, stock, height);
		treeDAO.create(tree);

		//StockSingleton.getStockSingleton().getStock().add(tree); // quan ho guarda al singleton -> canviar-la al sql


		//recalculateTotalStockValueOnAdd(tree.getStock(), tree.getCostPrice());// mirar si aquest metode és necessari

		logger.info("StockHandler :: createTree :: New tree created.");

	}

	public static void createFlower(String name, double sellPrice, double costPrice, int stock, String colour) {

		FlowerFactory factory = new FlowerFactory();
		Flower flower = (Flower) factory.createSpecificProduct(name, sellPrice, costPrice, stock, colour);
		flowerDAO.create(flower);

		//StockSingleton.getStockSingleton().getStock().add(flower);

		//recalculateTotalStockValueOnAdd(flower.getStock(), flower.getCostPrice());

		logger.info("StockHandler :: createFlower :: New flower created.");

	}

	public static void createDecoration(String name, double sellPrice, double costPrice, int stock, String material) {

		DecorationFactory factory = new DecorationFactory();
		Decoration decoration = (Decoration) factory.createSpecificProduct(name, sellPrice, costPrice, stock, material);
		decorationDAO.create(decoration);

		//StockSingleton.getStockSingleton().getStock().add(decoration);

		//recalculateTotalStockValueOnAdd(decoration.getStock(), decoration.getCostPrice());

		logger.info("StockHandler :: createDecoration :: New decoration created.");

	}

	public static void showCatalogue() { // nom + caracteristica + preu venda +id

		List<Tree> trees = treeDAO.readAll();
		List<Flower> flowers = flowerDAO.readAll();
		List<Decoration> decorations = decorationDAO.readAll();

		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toCatalogue());});

		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toCatalogue());});

		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toCatalogue());});

	}

	public static void showStock() { // nom + caracteristica + preu cost +id

		List<Tree> trees = treeDAO.readAll();
		List<Flower> flowers = flowerDAO.readAll();
		List<Decoration> decorations = decorationDAO.readAll();

		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toStock());});

		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toStock());});

		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toStock());});

	}

	public static String getTotalStockValue() {
		double totalStockValue = calculateTotalStockValue();
		return Constants.Menus.STOCK_VALUE + totalStockValue + " eur.\n";

	}
	public static double calculateTotalStockValue() {
		double totalValue = 0.0;

		// Calcular el valor total del stock de los árboles
		List<Tree> trees = treeDAO.readAll();
		for (Tree tree : trees) {
			totalValue += tree.getStock() * tree.getCostPrice();
		}

		// Calcular el valor total del stock de las flores
		List<Flower> flowers = flowerDAO.readAll();
		for (Flower flower : flowers) {
			totalValue += flower.getStock() * flower.getCostPrice();
		}

		// Calcular el valor total del stock de las decoraciones
		List<Decoration> decorations = decorationDAO.readAll();
		for (Decoration decoration : decorations) {
			totalValue += decoration.getStock() * decoration.getCostPrice();
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
				recalculateTotalStockValueOnAdd(Integer.parseInt(stockToBeAdded), product.getCostPrice());
				AppHandler.printText(Constants.Menus.STOCK_UPDATE);

			} while(!Validations.isNaturalNumber(stockToBeAdded));

		}else {
			AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
		}
	}

	public static Product findProductByName(String name) {
		Product product = flowerDAO.getOne(name);
		if (product == null) {
			product = decorationDAO.getOne(name);
		}
		if (product == null) {
			product = treeDAO.getOne(name);
		}
		return product;
	}

	/*public static Product findProductByProductId(int productId) {

		Product product = null;

		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.productId() == productId) {
				product = prod;
				break;
			}
		}

		return product;

	}*/

	public static boolean removeProductByProductName(String name) {
		Flower flower = flowerDAO.getOne(name);
		if (flower != null) {
			flowerDAO.delete(flower);
			return true;
		}
		Decoration decoration = decorationDAO.getOne(name);
		if (decoration != null) {
			decorationDAO.delete(decoration);
			return true;
		}
		Tree tree = treeDAO.getOne(name);
		if (tree != null) {
			treeDAO.delete(tree);
			return true;
		}

		return false;
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

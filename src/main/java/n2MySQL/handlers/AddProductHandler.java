package n2MySQL.handlers;
import com.mongodb.client.MongoClient;
import n2MySQL.beans.Decoration;
import n2MySQL.beans.Flower;
import n2MySQL.beans.Product;
import n2MySQL.beans.Tree;
import n2MySQL.mongoDatabase.DecorationMongo;
import n2MySQL.mongoDatabase.FlowerMongo;
import n2MySQL.mongoDatabase.TreeMongo;
import n2MySQL.utils.Constants;
import n2MySQL.utils.Utils;
import n2MySQL.utils.Validations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import org.bson.Document;

public class AddProductHandler {

	private static final Logger logger = LoggerFactory.getLogger(AddProductHandler.class);

	public static void runAddProduct() {
		logger.info("AddProductHandler :: runAddProduct :: About to add a new product.");

		AppHandler.printText(Constants.Headings.ADD_PRODUCT);

		String productOption = "";

		do {
			AppHandler.printText(TextMenuHandler.getProductMenu());

			do {
				AppHandler.printText(TextMenuHandler.getEnterValidOption());
				productOption = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidProductOption(productOption));

			processAddProductOption(productOption);

		} while (!productOption.equalsIgnoreCase("0"));
	}

	private static void processAddProductOption(String productOption) {
		switch (productOption) {
			case "1":
				runCreateTree();
				break;
			case "2":
				runCreateFlower();
				break;
			case "3":
				runCreateDecoration();
				break;
			case "0":
				runExitProductOption();
				break;
			default:
				break;
		}
	}

	private static void runCreateTree() {
		String treeName = "";
		do {
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			treeName = AppHandler.readConsoleInput().trim();
		} while (!Validations.isValidProductName(treeName));

		Product product = StockHandler.findProductByName(treeName);

		if (product == null) {
			String sellPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(sellPrice));

			String costPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(costPrice));

			String stock = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
			} while (!Validations.isNaturalNumber(stock));

			String height = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidHeight());
				height = AppHandler.readConsoleInput().trim();
			} while (!Validations.isNaturalNumber(height));

			Tree tree = new Tree(treeName, Double.parseDouble(sellPrice),
					Double.parseDouble(costPrice), Integer.parseInt(stock),
					Integer.parseInt(height));

			TreeMongo treeMongo = new TreeMongo(getMongoCollection());
			treeMongo.create(tree);
			treeMongo.close();

			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
		} else {
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
		}
	}

	private static void runCreateFlower() {
		String flowerName = "";
		do {
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			flowerName = AppHandler.readConsoleInput().trim();
		} while (!Validations.isValidProductName(flowerName));

		Product product = StockHandler.findProductByName(flowerName);

		if (product == null) {
			String sellPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(sellPrice));

			String costPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(costPrice));

			String stock = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
			} while (!Validations.isNaturalNumber(stock));

			String colour = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidColour());
				colour = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidColour(colour, AppHandler.getColours()));

			Flower flower = new Flower(flowerName, Double.parseDouble(sellPrice),
					Double.parseDouble(costPrice), Integer.parseInt(stock),
					colour);

			FlowerMongo flowerMongo = new FlowerMongo(getMongoCollection());
			flowerMongo.create(flower);
			flowerMongo.close();

			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
		} else {
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
		}
	}

	private static void runCreateDecoration() {
		String decorationName = "";
		do {
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			decorationName = AppHandler.readConsoleInput().trim();
		} while (!Validations.isValidProductName(decorationName));

		Product product = StockHandler.findProductByName(decorationName);

		if (product == null) {
			String sellPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(sellPrice));

			String costPrice = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidPrice(costPrice));

			String stock = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
			} while (!Validations.isNaturalNumber(stock));

			String material = "";
			do {
				AppHandler.printText(TextMenuHandler.getEnterValidMaterial());
				material = AppHandler.readConsoleInput().trim();
			} while (!Validations.isValidMaterialOption(material));

			Decoration decoration = new Decoration(decorationName, Double.parseDouble(sellPrice),
					Double.parseDouble(costPrice), Integer.parseInt(stock),
					Utils.getMaterial(material));

			DecorationMongo decorationMongo = new DecorationMongo(getMongoCollection());
			decorationMongo.create(decoration);
			decorationMongo.close();

			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
		} else {
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
		}
	}


	private static void runExitProductOption() {
		logger.info("AddProductHandler :: runExitProductOption :: Exiting the add product menu.");
		AppHandler.printText(TextMenuHandler.getExitCurrentMenuMessage());
	}

	private static MongoCollection<Document> getMongoCollection() {
		MongoClient mongoClient = MongoClients.create(Constants.RunningModes.MONGOCONNECTION);
		MongoDatabase database = mongoClient.getDatabase("flowershop");
		return database.getCollection("products");
	}
}

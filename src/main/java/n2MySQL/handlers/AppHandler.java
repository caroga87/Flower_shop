package n2MySQL.handlers;

import n2MySQL.MySQLdatabase.ConnectionFactory;
import n2MySQL.MySQLdatabase.SQLDatabaseConnection;
import n2MySQL.io.FlowerShopFileReader;
import n2MySQL.utis.Constants;
import n2MySQL.utis.Validations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;


public class AppHandler {
	private static Logger logger = LoggerFactory.getLogger(AppHandler.class);

	private static Scanner scanner;
	private static List<String> colours;


	@SuppressWarnings("static-access")
	public AppHandler() {
		super();
		scanner = new Scanner(System.in);
		this.colours = FlowerShopFileReader.readColours(Constants.Files.COLOURS);
	}

	public static String readConsoleInput() {
		return scanner.nextLine();
	}

	public static void closeConsoleInput() {
		scanner.close();
	}

	public static List<String> getColours() {
		return colours;
	}

	public static void printText(String text) {
		System.out.println(text);
	}

	public void getConnectionFlowerShop(String motor) throws SQLException {

		ConnectionFactory connection = new ConnectionFactory();
		connection.getConnection(motor);
		runMainMenu();
	}



	public static void runMainMenu() {

		String menuOption = "";

		do {

			printText(TextMenuHandler.getMainMenu());

			do {

				printText(TextMenuHandler.getEnterValidOption());
				menuOption = readConsoleInput().trim();

			} while(!Validations.isValidOption(menuOption));

			processMainMenuOption(menuOption);

		} while(!menuOption.equalsIgnoreCase("0"));

		closeConsoleInput();

	}

	private static void processMainMenuOption(String menuOption) {

		switch(menuOption) {
			case "1":
				AddProductHandler.runAddProduct();
				break;
			case "2":
				DeleteProductHandler.runDeleteProduct();
				break;
			case "3":
				StockHandler.runViewCatalogue();
				break;
			case "4":
				StockHandler.runAddProductsToStock();
				break;
			case "5":
				StockHandler.runViewStock();
				break;
			case "6":
				StockHandler.runViewStockValue();
				break;
			case "7":
				CreateTicketHandler.runCreateNewTicket();
				break;
			case "8":
				TicketHandler.runViewSales();
				break;
			case "9":
				TicketHandler.runViewEarnings();
				break;
			case "0":
				runExitFlowerShop();
				break;
			default:
				break;
		}

	}

	private static void runExitFlowerShop() {

		logger.info("AppHandler :: runExitFlowerShop :: Flower Shop App shutting down...");

		
		AppHandler.printText(TextMenuHandler.getExitMessage());

	}
}

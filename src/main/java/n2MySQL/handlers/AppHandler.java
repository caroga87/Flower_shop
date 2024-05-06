package n2MySQL.handlers;

import n2MySQL.MySQLdatabase.connections.ConnectionFactory;
import n2MySQL.MySQLdatabase.connections.IConnection;
import n2MySQL.MySQLdatabase.connections.RunningModeSingleton;
import n2MySQL.exceptions.EmptyDatabaseException;
import n2MySQL.io.FlowerShopFileReader;
import n2MySQL.utils.Constants;
import n2MySQL.utils.Validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flower_shop.handlers.menus.FlowerShopHandler;

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
	
	

	public void runApp()  {

		runChooseRunningModeMenu();
		runMainMenu();
	}
	
	private static void runChooseRunningModeMenu() {
		
		String runningMode = "";
		
		do {
			
			printText(Constants.Menus.APP_RUNNING_MODE);
			runningMode = readConsoleInput().trim();
			
		} while(!Validations.isValidRunningMode(runningMode));
		
		processRunningMode(runningMode);
		
		//Testing connections.
		//SE HA DE BORRAR.
		IConnection connection = null;
		
		try {
			connection = ConnectionFactory.getConnection(RunningModeSingleton.getRunningModeSingleton().getRunningMode());
		} catch (EmptyDatabaseException e) {
			logger.error("AppHandler :: runChooseRunningModeMenu :: ", e);
		}
		
		if(connection != null) {
			printText("Conexión creada a " + RunningModeSingleton.getRunningModeSingleton().getRunningMode());
		}
	}
	
	private static void processRunningMode(String runningMode) {
		
		switch(runningMode) {
			case "1":
				RunningModeSingleton.getRunningModeSingleton().setRunningMode(Constants.RunningModes.MY_SQL);
				printText(Constants.RunningModes.MY_SQL + "\n\n");
				break;
			case "2":
				RunningModeSingleton.getRunningModeSingleton().setRunningMode(Constants.RunningModes.MONGODB);
				printText(Constants.RunningModes.MONGODB + "\n\n");
				break;
			default:
				break;
		}	
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

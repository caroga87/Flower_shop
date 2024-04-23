package n1exercici1.handlers;

import java.util.Scanner;

import n1exercici1.beans.FlowerShop;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.StockSingleton;
import n1exercici1.singletons.TicketSingleton;
import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class AppHandler {

	private static Scanner scanner;
	private ProductHandler productHandler;
	

	public AppHandler() {
		super();
		AppHandler.scanner = new Scanner(System.in);
		this.productHandler = new ProductHandler();
	}
	
	public void startApp() {
		
		if(!loadFlowerShopSaves()) {
			createFlowerShop();
		}
		loadData();
		runApp();
	}
	
	private boolean loadFlowerShopSaves() {
		
		boolean flowerShopLoaded = false;
		
		FlowerShopSingleton.getFlowerShopSingleton().loadFlowerShop();
		
		if(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop() != null) {
			
			flowerShopLoaded = true;
			
			FlowerShopFileReader.readIds(Constants.Files.IDS);
			TicketSingleton.getTicketSingleton().loadSales();
			StockSingleton.getStockSingleton().loadStock();
			
		} else {
			
			//if we reach this point, it means it is the first time using the app or there is a problem with the consistency of the files
			//we delete all files to start over from scratch
			clearAllFiles();
			
		}
		
		return flowerShopLoaded;
		
	}

	private void clearAllFiles() {
	
	FileManager.deleteFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS, true);
	FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP, true);
	FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES, true);
	FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK, true);
	
}
	
	
	private void loadData()	{
		
		
	}
	
	private void createFlowerShop() {
		

		String name = "";
		
		printText(TextMenuHandler.getCreateFlowerShopMenu());
		
		do {
			
			printText(TextMenuHandler.getEnterValidNameMessage());
			name = readInput().trim();
			
		} while(!Validations.isValidName(name));
		
		FlowerShop flowerShop = new FlowerShop(name);
		FlowerShopSingleton.getFlowerShopSingleton().setFlowerShop(flowerShop);
		
		printText(TextMenuHandler.getFlowerShopCreatedMessage());	
		
	}
	
	
	private void runApp() {
		
		String menuOption = "";
		
		do {
			printText(TextMenuHandler.getMainMenu());
			
			do {
				printText(TextMenuHandler.getChooseAnOption());
				menuOption = readInput().trim();
			}while(!Validations.validateMenuEightOption(menuOption));
			
			processMainOption(menuOption);
			
		}while(!menuOption.equals("0"));
		
		closeScanner();
	}


	private void processMainOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				
				productHandler.runAddProduct();
				
				break;
			case "2":
				//removeProduct().
				
				break;
			case "3":
				//showStock().
				
				break;
			case "4":
				//showQuantityStock().
				
				break;
			case "5":
				//showValueFlowerShop().
				
				break;
			case "6":
				//createTicket().
				
				break;
			case "7":
				//showHistoryTicket().
				
				break;
			case "8":
				//showEarnings().
				
				break;	
			case "0":
				runExitFlowerShop();
				break;
			default:
				break;
		}		
	}
	
	private void runExitFlowerShop() {

		FlowerShopSingleton.getFlowerShopSingleton().handleFlowerShopPersistance();
		TicketSingleton.getTicketSingleton().handleMaxAssignedTicketIdPersitence();
		TicketSingleton.getTicketSingleton().handleSalesPersistence();
		StockSingleton.getStockSingleton().handleMaxAssignedProducIdPersitence();
		StockSingleton.getStockSingleton().handleStockPersistence();
		
		printText(TextMenuHandler.getExitMessage());
		
	}
	
	
	public static void printText(String text) {
		
		System.out.println(text);
	}
	
	//scanner methods.
	public static String readInput() {
		
		return scanner.nextLine();
	}
	
	
	private void closeScanner() {
		scanner.close();
	}
}

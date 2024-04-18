package n1exercici1.handlers;

import java.util.Scanner;

import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class AppHandler {
	
	private static Scanner scanner;
	
	public AppHandler() {
		super();
		AppHandler.scanner = new Scanner(System.in);
	}
	
	public void runApp() {
		
		String menuOption = "";
		
		do {
			showMenu(Constants.Menu.APP);
			
			do {
				printText(TextMenuHandler.getChooseAnOption());
				menuOption = readInput().trim();
			}while(!Validations.validateMenuFourOption(menuOption));
			
			processMainOption(menuOption);
			
		}while(!menuOption.equals("0"));
		
		closeScanner();
	}

	private void showMenu(String menu) {
		
		String menuText = "";
		
		if(menu.equalsIgnoreCase(Constants.Menu.APP)) {
			menuText = TextMenuHandler.getMainMenu();
		}else if(menu.equalsIgnoreCase(Constants.Menu.CATALOGUE)) {
			menuText = TextMenuHandler.getCatalogueMenu();
		}else if(menu.equalsIgnoreCase(Constants.Menu.STOCK)) {
			menuText = TextMenuHandler.getStockMenu();
		}else if(menu.equalsIgnoreCase(Constants.Menu.SALES)) {
			menuText = TextMenuHandler.getSalesMenu();
		}else {
			throw new IllegalArgumentException(Constants.Exceptions.TYPE);
		} 
		printText(menuText);
	}

	private void processMainOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				CatalogueHandler catalogue = new CatalogueHandler();
				catalogue.runCatalogue();
				break;
			case "2":
				StockHandler stock = new StockHandler();
				stock.runStock();
				break;
			case "3":
				SalesHandler sales = new SalesHandler();
				sales.runSales();
				break;
			case "0":
				printText(TextMenuHandler.getExitMessage(Constants.Menu.APP));
				break;
			default:
				break;
		}		
	}
	
	
	public void printText(String text) {
		
		System.out.println(text);
	}
	
	//scanner methods.
	public String readInput() {
		
		return scanner.nextLine();
	}
	
	
	private void closeScanner() {
		scanner.close();
	}
}

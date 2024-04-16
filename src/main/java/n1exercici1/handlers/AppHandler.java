package n1exercici1.handlers;

import java.util.Scanner;

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
				showMainMenu();
				
				do {
					printText(TextMenuHandler.getChooseAnOption());
					menuOption = readInput().trim();
				}while(!Validations.validateMenuFourOption(menuOption));
				
				processMainOption(menuOption);
				
			}while(!menuOption.equals("0"));
			
			closeScanner();
	}
	
	private void showMainMenu() {
		
		 String menuText = TextMenuHandler.getMainMenu();
		 printText(menuText);
	}
	
	private void processMainOption(String menuOptionCatalogue) {

		switch (menuOptionCatalogue) {
			case "1": 
				printText(TextMenuHandler.getCatalogueMenu());
				break;
			case "2":
				printText(TextMenuHandler.getStockMenu());
				break;
			case "3":
				printText(TextMenuHandler.getSalesMenu());
				break;
			case "0":
				printText(TextMenuHandler.getExitMessage());
				break;
			default:
				break;
		}		
	}
	
	private void printText(String text) {
		
		System.out.println(text);
	}
	
	private String readInput() {
		return scanner.nextLine();
	}
	
	private void closeScanner() {
		scanner.close();
	}
}

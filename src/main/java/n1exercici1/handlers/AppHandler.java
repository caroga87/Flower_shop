package n1exercici1.handlers;

import java.util.Scanner;

import n1exercici1.utils.Validations;

public class AppHandler {

	private static Scanner scanner;
	

	public AppHandler() {
		super();
		AppHandler.scanner = new Scanner(System.in);
	}
	
	public void startApp() {
		
		loadData();
		runApp();
	}
	
	private void loadData()	{
		
		
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
				//addProduct().
				
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
				printText(TextMenuHandler.getExitMessage());
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

package n1exercici1.handlers;

import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class StockHandler {
	
	private AppHandler appHandler;
	
	public StockHandler() {
		super();
		this.appHandler = new AppHandler();
	}
	
	public void runStock() {
		
		String menuOption = "";
		
		do {
			appHandler.printText(TextMenuHandler.getStockMenu());
			
			do {
				appHandler.printText(TextMenuHandler.getChooseAnOption());
				menuOption = appHandler.readInput().trim();
			}while(!Validations.validateMenuFourOption(menuOption));
			
			processStockOption(menuOption);
			
		}while(!menuOption.equals("0"));
	}
	
	private void processStockOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "0":
				appHandler.printText(TextMenuHandler.getExitMessage(Constants.Menu.STOCK));
				break;
			default:
				break;
		}		
	}
}

package n1exercici1.handlers;

import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class SalesHandler {

	private AppHandler appHandler;
	
	public SalesHandler() {
		super();
		this.appHandler = new AppHandler();
	}
	
	public void runSales() {
		
		String menuOption = "";
		
		do {
			appHandler.printText(TextMenuHandler.getSalesMenu());
			
			do {
				appHandler.printText(TextMenuHandler.getChooseAnOption());
				menuOption = appHandler.readInput().trim();
			}while(!Validations.validateMenuFourOption(menuOption));
			
			processSalesOption(menuOption);
			
		}while(!menuOption.equals("0"));
	}
	
	private void processSalesOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				// create ticket
				break;
			case "2":
				// sales history
				break;
			case "3":
				// Accounting
				break;
			case "0":
				appHandler.printText(TextMenuHandler.getExitMessage(Constants.Menu.SALES));
				break;
			default:
				break;
		}		
	}
}

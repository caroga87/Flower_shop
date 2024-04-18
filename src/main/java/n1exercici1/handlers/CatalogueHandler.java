package n1exercici1.handlers;

import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class CatalogueHandler {
	
	private AppHandler appHandler;
	
	public CatalogueHandler() {
		super();
		this.appHandler = new AppHandler();
	}
	
	public void runCatalogue() {
		
		String menuOption = "";
		
		do {
			appHandler.printText(TextMenuHandler.getCatalogueMenu());
			
			do {
				appHandler.printText(TextMenuHandler.getChooseAnOption());
				menuOption = appHandler.readInput().trim();
			}while(!Validations.validateMenuFourOption(menuOption));
			
			processCatalogueOption(menuOption);
			
		}while(!menuOption.equals("0"));
	}
	
	private void processCatalogueOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				appHandler.printText(createProduct());
				break;
			case "2":
				appHandler.printText(removeProduct());
				break;
			case "3":
				showAllProducts();
				break;
			case "0":
				appHandler.printText(TextMenuHandler.getExitMessage(Constants.Menu.CATALOGUE));
				break;
			default:
				break;
		}		
	}
	
	private String createProduct() {
		
		
		return "";
	}
	
	private String removeProduct() {
		
		return "";
	}
	
	private void showAllProducts() {
		
	
	}
}

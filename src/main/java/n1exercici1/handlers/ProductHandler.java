package n1exercici1.handlers;

import n1exercici1.utils.Constants;
import n1exercici1.utils.Validations;

public class ProductHandler {

	public void runAddProduct() {
		
		
		AppHandler.printText(Constants.Headings.ADD_PRODUCT);
		
		String productOption = "";

		do {
			
			AppHandler.printText(TextMenuHandler.getProductMenu());
			
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidOptionMessage());
				productOption = AppHandler.readInput().trim();
				
			} while(!Validations.isValidProductOption(productOption));
			
			processAddProductOption(productOption);
			
		} while(!productOption.equalsIgnoreCase("0"));
		
	}
	
	private void processAddProductOption(String productOption) {
		
		switch(productOption) {
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
	
	private void runCreateTree() {
		
	}
	
	private void runCreateFlower() {
		
	}
	
	private void runCreateDecoration() {
		
	}
	
	private void runExitProductOption() {
		
	}
	
	
}

package n1exercici1.handlers;

import n1exercici1.utils.Constants;

public class TextMenuHandler {

	public static String getMainMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Catalogue.\n");
		sb.append("2: Stock.\n");
		sb.append("3: Sales.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getCatalogueMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Create/Add Product.\n");
		sb.append("2: Remove Product.\n");
		sb.append("3: Show Catalogue.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	

	public static String getStockMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: General Stock.\n");
		sb.append("2: Stock Quantity.\n");
		sb.append("3: Stock Value.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getSalesMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Create Ticket.\n");
		sb.append("2: Sales History.\n");
		sb.append("3: Accounting.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getChooseAnOption() {
		
		return Constants.Messages.CHOOSE;
	}
	
	public static String getExitMessage(String switchType) {
		
		
		if(switchType.equalsIgnoreCase("App")) {
			switchType = Constants.Messages.EXIT_APP;
		}else if(switchType.equalsIgnoreCase("Catalogue")) {
			switchType = Constants.Messages.EXIT_CATALOGUE;
		}else if(switchType.equalsIgnoreCase("Stock")) {
			switchType = Constants.Messages.EXIT_STOCK;
		}else if(switchType.equalsIgnoreCase("Sales")) {
			switchType = Constants.Messages.EXIT_SALES;
		}else {
			throw new IllegalArgumentException(Constants.Exceptions.TYPE);
		}
		return switchType;
	}
}

package n1exercici1.handlers;

import n1exercici1.utils.Constants;

public class TextMenuHandler {

public static String getMainMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Catalogue.\n");
		sb.append("2: Stocks.\n");
		sb.append("3: Sales.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getCatalogueMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Create/Add Product.\n");
		sb.append("2: Remove Product.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	

	public static String getStockMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: General stock.\n");
		sb.append("2: Quantity stock.\n");
		sb.append("3: Stock's value\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getSalesMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Create ticket.\n");
		sb.append("2: History'tickets.\n");
		sb.append("3: Accounting.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getChooseAnOption() {
		
		return Constants.Messages.CHOOSE;
	}
	
	public static String getExitMessage() {
		
		return Constants.Messages.EXIT_APP;
	}
}

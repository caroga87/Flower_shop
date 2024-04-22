package n1exercici1.handlers;

import n1exercici1.utils.Constants;

public class TextMenuHandler {

	public static String getMainMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("---- FLOWER SHOP ----\n\n");
		sb.append("1: Create product.\n");
		sb.append("2: Remove product.\n");
		sb.append("3: Show Stock.\n");
		sb.append("4: Show quantity Stock.\n");
		sb.append("5: Show value stock.\n");
		sb.append("6: Create ticket.\n");
		sb.append("7: Show History Tickets\n");
		sb.append("8: Show earnings.\n");
		sb.append("0: Exit.\n\n");;
		return sb.toString();
	}
	
	
	public static String getEnterTypeProduct() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append("1: Create product.\n");
		sb.append("2: Remove product.\n");
		sb.append("3: Show Stock.\n");
		sb.append("4: Show quantity Stock.\n");
		sb.append("5: Show value stock.\n");
		sb.append("6: Create ticket.\n");
		sb.append("7: Show History Tickets\n");
		sb.append("8: Show earnings.\n");
		sb.append("0: Exit.\n\n");
		
		return sb.toString();
	}
	
	public static String getEnterNameProduct() {
		
		return Constants.CreateProduct.PRODUCT_NAME;
	}
	
	public static String getEnterCostPriceProduct() {
		
		return Constants.CreateProduct.PRODUCT_COST_PRICE;
	}
	
	public static String getEnterSalePriceProduct() {
		
		return Constants.CreateProduct.PRODUCT_SALE_PRICE;
	}
	
	public static String getEnterStockProduct() {
		
		return Constants.CreateProduct.PRODUCT_STOCK;
	}
	
	public static String getAskAttribute(String productType)	{
		
		StringBuilder sb = new StringBuilder();
		if(productType.equalsIgnoreCase("")) {
			sb.append(Constants.CreateProduct.ATTRIBUTE_TREE);
		}else if(productType.equalsIgnoreCase("")) {
			sb.append(Constants.CreateProduct.ATTRIBUTE_FLOWER);
		}else if(productType.equalsIgnoreCase("")) {
			sb.append(Constants.CreateProduct.ATTRIBUTE_DECORATION);
			sb.append("");
			sb.append(" or ");
			sb.append("");
			sb.append("): \n");
		}else {
			;
		}
		
		return sb.toString();
	}
	

	public static String getChooseAnOption() {
		
		return Constants.Messages.CHOOSE;
	}
	
	public static String getExitMessage() {
		
		return Constants.MainMenu.EXIT_MAIN_MENU;
	}
}

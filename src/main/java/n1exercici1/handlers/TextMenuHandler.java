package n1exercici1.handlers;

import java.util.Arrays;
import java.util.List;

import n1exercici1.enums.ProductTypeEnum;
import n1exercici1.utils.Constants;

public class TextMenuHandler {
	
	public static String getCreateFlowerShopMenu() {
		return Constants.Menus.CREATE_FS_MENU;
	}

	public static String getMainMenu() {
		
		return Constants.Menus.MAIN_MENU;
	}
	
	public static String getEnterNameProduct() {
		
		return Constants.Menus.PRODUCT_NAME;
	}
	
	public static String getEnterCostPriceProduct() {
		
		return Constants.Menus.COST_PRICE;
	}
	
	public static String getEnterSalePriceProduct() {
		
		return Constants.Menus.SELL_PRICE;
	}
	
	public static String getEnterStockProduct() {
		
		return Constants.Menus.STOCK;
	}
	

	public static String getChooseAnOption() {
		
		return Constants.Messages.CHOOSE;
	}
	
	public static String getExitMessage() {
		
		return Constants.Menus.EXIT;
	}
	
	public static String getEnterValidOptionMessage() {
		return Constants.Menus.VALID_OPTION;
	}
	
	public static String getEnterValidNameMessage() {
		
		return Constants.Menus.VALID_NAME;
	}
	
	public static String getFlowerShopCreatedMessage() {
		
		return Constants.Menus.CREATED_FS;
	}
	
	public static String getProductMenu() {
		
		StringBuilder sb = new StringBuilder();
		
		List<ProductTypeEnum> productTypeEnumValues = Arrays.asList(ProductTypeEnum.values());
		
		int count = 1;
		for(ProductTypeEnum enumValue : productTypeEnumValues) {
			sb.append(count).append(". ").append(enumValue.getType()).append("\n");
			count++;
		}
		
		sb.append("0. Exit\n");
		
		return sb.toString();
	}
}

package n2MySQL.handlers;

import n2MySQL.utils.Validations;


public class DeleteProductHandler {

	

	public static void runDeleteProduct() {

		

		//product id
		String productId = "";
		do {

			AppHandler.printText(TextMenuHandler.getEnterValidProductId());
			productId = AppHandler.readConsoleInput().trim();

		} while(!Validations.isNaturalNumber(productId));
//		Query
//		boolean deleted = StockHandler.removeProductByProductId(Integer.parseInt(productId));
//
//		if(deleted) {
//			AppHandler.printText(TextMenuHandler.getDeletedMessage());
//		} else {
//			AppHandler.printText(TextMenuHandler.getNotDeletedMessage());
//		}

	}
}

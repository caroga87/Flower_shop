package n2MySQL.handlers;

import n2MySQL.utils.Validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DeleteProductHandler {

	private static Logger logger = LoggerFactory.getLogger(DeleteProductHandler.class);

	public static void runDeleteProduct() {

		logger.info("DeleteProductHandler :: runDeleteProduct :: About to delete a product.");

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

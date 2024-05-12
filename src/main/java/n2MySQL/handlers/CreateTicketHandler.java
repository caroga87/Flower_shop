package n2MySQL.handlers;

import n2MySQL.MySQLdatabase.queries.ProductSQL;
import n2MySQL.MySQLdatabase.queries.TicketSQL;
import n2MySQL.beans.Product;
import n2MySQL.utils.Validations;
import n2MySQL.beans.Ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class CreateTicketHandler {

	private static Logger logger = LoggerFactory.getLogger(CreateTicketHandler.class);
	private static TicketSQL ticketSQL;
	private static ProductSQL productSQL;

	public static void runCreateNewTicket() {

		logger.info("CreateNewTicketMenuHandler :: runCreateNewTicket :: About to create a new ticket.");

		Ticket newTicket = new Ticket();
		//Query
		//newTicket.setTicketId(SalesSingleton.getSalesSingleton().getNextTicketId());
		AppHandler.printText(newTicket.toString());

		String ticketMenuOption = "";
		do {

			AppHandler.printText(TextMenuHandler.getTicketMenu());

			do {

				AppHandler.printText(TextMenuHandler.getEnterValidOption());
				ticketMenuOption = AppHandler.readConsoleInput().trim();

			} while(!Validations.isValidTicketOption(ticketMenuOption));

			processTicketMenuOption(ticketMenuOption, newTicket);

			if(ticketMenuOption.equalsIgnoreCase("0")) {
				ticketSQL.create(newTicket);
				TicketHandler.recalculateTotalEarnings(newTicket.getTotalAmount());

			}

		} while(!ticketMenuOption.equalsIgnoreCase("0"));

	}

	private static boolean processTicketMenuOption(String ticketMenuOption, Ticket newTicket) {

		boolean ticketOk = false;

		switch(ticketMenuOption) {
			case "1":
				runAddProductToMenuOption(newTicket);
				break;
			case "2":
				runDeleteProductFromMenuOption(newTicket);
				break;
			case "0":
				runExitTicketOption(newTicket);
				break;
			default:
				break;
		}

		return ticketOk;

	}

	private static void runAddProductToMenuOption(Ticket newTicket) {
		AppHandler.printText(TextMenuHandler.getEnterValidProductName());
		String productName = AppHandler.readConsoleInput().trim();
		Product product = productSQL.getOneByName(productName);

		if (product != null) {
			AppHandler.printText(TextMenuHandler.getEnterValidQuantity());
			String quantity = AppHandler.readConsoleInput().trim();

			if (StockHandler.thereIsEnoughStock(product, Integer.parseInt(quantity))) {
				StockHandler.deductStock(product, Integer.parseInt(quantity));
				recalculateTicketTotalAmountOnProductAdd(newTicket, Integer.parseInt(quantity), product.getSellPrice());
				newTicket.getProducts().put(product, Integer.valueOf(quantity));
				AppHandler.printText(TextMenuHandler.getProductAddedMessage());

				AppHandler.printText(newTicket.toString());
			} else {
				System.out.println(TextMenuHandler.getInsufficientStockMessage());
			}
		} else {
			System.out.println(TextMenuHandler.getProductNotFoundMessage() + ", name: " + productName + "\n");
		}

	}

	private static void runDeleteProductFromMenuOption(Ticket newTicket) {
		boolean hasProducts = !newTicket.getProducts().isEmpty();;
		if (hasProducts) {
			AppHandler.printText(TextMenuHandler.getEnterValidProductId());
			String productId = AppHandler.readConsoleInput().trim();
			Product product =productSQL.getOne(Integer.valueOf(productId));

			if (product != null) {
				int quantity = findProductQuantityInTicket(newTicket, product);
				StockHandler.putBackInStock(product, quantity);
				newTicket.getProducts().remove(product);
				recalculateTicketTotalAmountOnProductDelete(newTicket, quantity, product.getSellPrice());
				System.out.println(TextMenuHandler.getDeletedMessage());
				System.out.println(newTicket);
			} else {
				System.out.println(TextMenuHandler.getProductNotFoundMessage() + ", id: " + productId + "\n");
			}
		} else {
			System.out.println(TextMenuHandler.getTicketHasNoProductsMessage());
		}

	}

	public static boolean checkTicketHasProducts(Ticket newTicket) {
		return !newTicket.getProducts().isEmpty();
	}

	public static int findProductQuantityInTicket(Ticket ticket, Product product) {
		Map<Product, Integer> products = ticket.getProducts();
		return products.containsKey(product) ? products.get(product) : 0;
	}

	public static void addProductToTicket(Ticket ticket, Product product, int quantity) {
		Map<Product, Integer> products = ticket.getProducts();
		products.put(product, quantity);
	}

	public static void removeProductFromTicket(Ticket ticket, String productName) {
		ticket.getProducts().remove(productName);
	}

	public static void recalculateTicketTotalAmountOnProductAdd(Ticket ticket, int quantity, double sellPrice) {
		double productTotal = quantity * sellPrice;
		ticket.setTotalAmount(ticket.getTotalAmount() + productTotal);
	}

	public static void recalculateTicketTotalAmountOnProductDelete(Ticket ticket, int quantity, double sellPrice) {
		double productTotal = quantity * sellPrice;
		ticket.setTotalAmount(ticket.getTotalAmount() - productTotal);
	}

	private static void runExitTicketOption(Ticket newTicket) {

		boolean hasProducts = checkTicketHasProducts(newTicket);

		if(hasProducts) {

			AppHandler.printText(newTicket.toString());
			AppHandler.printText(TextMenuHandler.getSuccessfulPurchaseMessage());

		} else {

			newTicket = null;
			AppHandler.printText(TextMenuHandler.getNotSuccessfulPurchaseMessage());
		}
	}
}

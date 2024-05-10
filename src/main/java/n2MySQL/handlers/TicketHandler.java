package n2MySQL.handlers;

import n2MySQL.utils.Constants;
import n2MySQL.utils.Utils;
import n2MySQL.utils.Validations;


public class TicketHandler {


	public static void runViewSales() {


		String date = "";

		AppHandler.printText(TextMenuHandler.getDateMessage());

		do {

			AppHandler.printText(TextMenuHandler.getEnterValidDate());
			date = AppHandler.readConsoleInput().trim();

		} while(!Validations.isValidDate(Utils.appendTimeToDate(date)));

		AppHandler.printText(getSales(Utils.appendTimeToDate(date)));

	}

	private static String getSales(String sinceDate) {

		StringBuilder sb = new StringBuilder();

		sb.append(Constants.Headings.SALES);

//		for(Ticket ticket : SalesSingleton.getSalesSingleton().getSales()) {
//			if(Utils.parseDateFromString(ticket.getCreationDateTime()).after(Utils.parseDateFromString(sinceDate))) {
//				sb.append(ticket.toString());
//			}
//		}

		sb.append("\n");

		return sb.toString();

	}

	public static void runViewEarnings() {


//		AppHandler.printText(getEarnings());

	}

	private static String getEarnings() {

		StringBuilder sb = new StringBuilder();

		sb.append(Constants.Headings.EARNINGS);

//		for(Ticket ticket : SalesSingleton.getSalesSingleton().getSales()) {
//			sb.append("Ticket Id: ").append(ticket.getTicketId()).append(", ").append(ticket.getTotalAmount()).append(" eur.\n");
//		}
//
//		sb.append("\nTotal: ").append(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalEarnings()).append(" eur.\n");

		return sb.toString();

	}

	public static void recalculateTotalEarnings(double totalTicketAmount) {

//		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalEarnings() + totalTicketAmount;
//		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalEarnings(newTotal);

	}
}

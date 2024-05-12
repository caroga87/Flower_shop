package n2MySQL.beans;

import java.util.HashMap;
import java.util.Map;

import n2MySQL.utils.Utils;

public class Ticket{
	private int ticketId;
	private Map<Product, Integer> products; //Product & quantity
	private double totalAmount;
	private String creationDateTime;

	public Ticket() {
		super();
		this.products = new HashMap<>();
		this.creationDateTime = Utils.getCurrentDateTime();
	}

	public Ticket(int ticketId, Map<Product, Integer> products, double totalAmount, String creationDateTime) {
		this.ticketId = ticketId;
		this.products = products;
		this.totalAmount = totalAmount;
		this.creationDateTime = creationDateTime;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("\n\n_____ Ticket Id: ").append(ticketId).append(" _____\n");
		sb.append("Date/Time: ").append(creationDateTime).append("\n");
		products.forEach((product, quantity) -> {sb.append(quantity).append(" x ").append(product.getName()).append(" (Precio: ").append(product.getSellPrice()).append(")\n");
		});
		sb.append(totalAmount).append(" eur.\n");

		return sb.toString();

	}

}

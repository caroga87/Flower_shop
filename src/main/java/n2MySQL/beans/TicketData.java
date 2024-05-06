package n2MySQL.beans;

public class TicketData {
	private int quantity;
	private int productId;


	public TicketData(int quantity, int productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "TicketData [quantity=" + quantity
				+ ", productId=" + productId + "]";
	}
}

package n1exercici1.beans;

import java.io.Serializable;

public class Flower extends Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String colour;
	
	
	public Flower(String name, double price, int stock) {
		super(name, price, stock);
	}

	public Flower(String name, double price, int stock, String colour) {
		super(name, price, stock );
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Flower [colour=" + colour + "]";
	}

}

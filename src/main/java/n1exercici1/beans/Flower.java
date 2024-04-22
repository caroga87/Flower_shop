package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Flower")
public class Flower extends Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String colour;
	
	public Flower(String name, String costPrice, String salePrice, String stock, String colour) {
		super(name, costPrice, salePrice, stock);
		this.colour = colour;
		this.costPrice = Double.parseDouble(costPrice);
        this.salePrice = Double.parseDouble(salePrice);
        this.stock = Integer.parseInt(stock);
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
		
}

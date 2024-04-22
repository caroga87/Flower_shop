package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Decoration")
public class Decoration extends Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String type;

	public Decoration(String name, String costPrice, String salePrice, String stock, String type) {
		super(name, costPrice, salePrice, stock);
		this.type = type;
		this.costPrice = Double.parseDouble(costPrice);
        this.salePrice = Double.parseDouble(salePrice);
        this.stock = Integer.parseInt(stock);
		
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}

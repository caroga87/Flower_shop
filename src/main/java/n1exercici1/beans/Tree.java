package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Tree")
public class Tree extends Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String height;
	
	public Tree(String name, String costPrice, String salePrice, String stock, String attribute ) {
		super(name, costPrice, salePrice, stock);
		this.height =  attribute;
		this.costPrice = Double.parseDouble(costPrice);
        this.salePrice = Double.parseDouble(salePrice);
        this.stock = Integer.parseInt(stock);
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}



	
	

package n1exercici1.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Tree.class, name = "Tree"),
        @Type(value = Flower.class, name = "Flower"),
        @Type(value = Decoration.class, name = "Decoration")
})
public abstract class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idProduct;
    private static int nextID = 1;
    protected String name;
    protected double costPrice;
    protected double salePrice;
    protected int stock;

    public Product(String name, String costPrice, String salePrice, String stock) {
        this.idProduct = nextID++;
        this.name = name;
        this.costPrice = Double.parseDouble(costPrice);
        this.salePrice = Double.parseDouble(salePrice);
        this.stock = Integer.parseInt(stock);
    }

    
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public abstract String toString();
	
}

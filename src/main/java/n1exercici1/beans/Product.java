package n1exercici1.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public abstract class Product {
	private int idProduct;
    private static int nextID = 1;
    protected String name;
    protected double price;
    protected int stock;

    public Product(String name, double price, int stock) {
        this.idProduct = nextID++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
}

package n1exercici1.Products;

public abstract class Product {

    private int idProduct;
    private static int nextID = 1;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.idProduct = nextID++;
        this.name = name;
        this.price = price;
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

    public abstract String getType();

    public abstract String getAttribute();

    public abstract String toString();
}


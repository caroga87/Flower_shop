package n1exercici1.Products;

import static java.lang.String.valueOf;

public class Tree extends  Product {
    private double height;

    public Tree(String name, double price, double height) {
        super(name, price);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String getType() {
        return "Tree";
    }

    @Override
    public String getAttribute() {
        return valueOf(this.height); // to convert double to its String
    }

    @Override
    public String toString() {
        return "Tree " +getName() + ", height" +this.height +". Price "+getPrice() +"€.";
    }
}

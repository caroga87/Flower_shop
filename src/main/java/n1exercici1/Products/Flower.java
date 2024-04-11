package n1exercici1.Products;

public class Flower extends Product {
    private String color;

    public Flower(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getType() {
        return "Flower";
    }

    @Override
    public String getAttribute() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Flower " +getName() + " in color " +this.color + ". Price " +getPrice()+"€.";
    }
}

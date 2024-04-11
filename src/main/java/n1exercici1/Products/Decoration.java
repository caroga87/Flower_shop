package n1exercici1.Products;

import n1exercici1.Products.Enum.MaterialType;

public class Decoration extends  Product{
    private String  material;

    public Decoration(String name, double price, MaterialType materialType) {
        super(name, price);
        this.material=materialType.name().toLowerCase();

    }

    @Override
    public String getType() {
        return "Decoration";
    }

    @Override
    public String getAttribute() {
        return this.material;
    }

    @Override
    public String toString() {
        return "Decoration: " +getName() +" made of " +this.material +". Price " +getPrice() +"€.";
    }
}

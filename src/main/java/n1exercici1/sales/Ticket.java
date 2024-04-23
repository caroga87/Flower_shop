package n1exercici1.sales;

import n1exercici1.beans.Product;
import n1exercici1.utils.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ticket {

    private int ticketID;
    private static int nextID=1;
    private LocalDate date;
    private HashMap<Integer, Product> productSales;
    private float totalTicket=0.0F;

    public Ticket(LocalDate date, HashMap<Integer, Product> productSales) {
        this.ticketID =nextID++;
        this.date = date;
        this.productSales = productSales;
        totalTicket = calculateTotalPrice();
    }

    public int getTicketID() {
        return ticketID;
    }

    public LocalDate getDate() {
        return date;
    }

    public HashMap<Integer, Product> getProductSales() {
        return productSales;
    }

    public float getTotalTicket() {
        return totalTicket;
    }

    public void addProduct(int quantity, Product product){
        productSales.put(quantity, product);
    }

    public void removeProduct (int productID, Product product){
        for(Iterator<Map.Entry<Integer, Product>> iterator = productSales.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<Integer, Product>entry=iterator.next();
            if(product.getIdProduct()==productID){
                iterator.remove();
            }else {
                System.out.println(Constants.Messages.ID_NOT_FOUND);
            }
        }
    }

    public float calculateTotalPrice () {
        return (float) productSales.entrySet().stream().mapToDouble(entry -> entry.getKey() * entry.getValue().getPrice()).sum();
    }

    public void printTicket() {
        System.out.println("------- FLOWERSHOP --------");
        System.out.println("========== TICKET ==========");
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Products:");

        for (HashMap.Entry<Integer, Product> entry : productSales.entrySet()) {
            int quantity = entry.getKey();
            Product product = entry.getValue();
            System.out.printf("%-10s %-30s %-10s %-10s%n", quantity + "x", product.getName(), "Price: $" + product.getPrice(), "Total: $" + quantity * product.getPrice());
        }

        System.out.println("-----------------------------");
        System.out.printf("Total: $%.2f%n", totalTicket);
        System.out.println("=============================");
    }

}


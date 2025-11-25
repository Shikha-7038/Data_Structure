import java.util.ArrayList;
import java.util.List;

class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}
class Order{
    private int orderId;
    private List<Product> products;

    public Order(int id) {
        this.orderId = id;
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        double total = 0;
        for (Product p : products) {
            System.out.println("  - " + p.getName() + " : Rs " + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total Amount: Rs " + total);
    }
}
class Customer{
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        System.out.println(name + " placed Order ID " + order);
        orders.add(order);
    }

    public void showMyOrders() {
        System.out.println(name + "'s Orders:");
        for (Order o : orders) {
            o.showOrderDetails();
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}
public class EconomyDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Phone", 15000);
        Product p3 = new Product("Book", 500);

        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order(102);
        order2.addProduct(p2);

        Customer c1 = new Customer("Aarav");

        c1.placeOrder(order1);
        c1.placeOrder(order2);

        System.out.println();
        c1.showMyOrders();
    }
}

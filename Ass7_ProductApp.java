interface ProductInterface {
    void display();
}
class Product implements ProductInterface {
    String name;
    int price;
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}
class Electronic extends Product {
    int warranty;
    Electronic(String name, int price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }
    public void display() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Warranty: " + warranty + " years");
    }
}
public class ProductApp {
    public static void main(String[] args) {
        Electronic e = new Electronic("Laptop", 50000, 2);
        e.display();
    }
}

public class Mobile {
    String brand;
    String model;
    double price;
    Mobile() {
        brand = "Unknown";
        model = "Unknown";
        price = 0.0;
    }
    Mobile(String b, String m, double p) {
        brand = b;
        model = m;
        price = p;
    }
    Mobile(Mobile obj) {
        brand = obj.brand;
        model = obj.model;
        price = obj.price;
    }
    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : Rs." + price);
    }
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Samsung", "Galaxy S24", 74999);
        Mobile m3 = new Mobile(m2);
        System.out.println("Mobile 1:");
        m1.display();
        System.out.println("Mobile 2:");
        m2.display();
        System.out.println("Mobile 3:");
        m3.display();
    }
}















class Deliveryapp{
    String rest = "Tomato's";
    String item = "Lasagna";
    int quantity = 1;
    float price = 549;
    String orderid = "F67B23";
    String address = "Kohinoor Planet, Aundh";
    String payment = "Online";
    int time = 40;
    void display(){
        System.out.println("Delivery Status:");
        System.out.println("Estimated Delivery Time: "+time+" minutes");
    }
    class Orderdetails{
        void ordershow(){
            System.out.println("Restaurant: "+rest);
            System.out.println("Item: "+item);
            System.out.println("Quantity: "+quantity);
            System.out.println("Price: "+price);
            System.out.println("Payment mode: "+payment);
            System.out.println("Delivery Address: "+address);
        }
    }
}
public class FoodApp {
    public static void main(String[] args) {
        Deliveryapp d = new Deliveryapp(){
            void display(){
                System.out.println("Your order is being prepared");
                super.display();
            }
        };
        d.display();
        Deliveryapp.Orderdetails o = d.new Orderdetails();
        o.ordershow();
    }
}

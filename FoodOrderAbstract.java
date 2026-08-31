abstract class FoodOrder {
    String customerName;
    String orderId;
    double foodAmount;
    FoodOrder(String customerName, String orderId, double foodAmount) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.foodAmount = foodAmount;
    }
    abstract void calculateBill();
    void displayBasicDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Order ID      : " + orderId);
        System.out.println("Food Amount   : ₹" + foodAmount);
    }
}
class DineInOrder extends FoodOrder {
    int tableNumber;
    double serviceCharge;
    double gst;
    double discount;
    DineInOrder(String customerName, String orderId, double foodAmount,int tableNumber) {
        super(customerName, orderId, foodAmount);
        this.tableNumber = tableNumber;
    }
    void calculateBill() {
        System.out.println("\n===== DINE-IN ORDER =====");
        serviceCharge = foodAmount * 0.05;
        gst = foodAmount * 0.05;
        if (foodAmount >= 2000) {
            discount = foodAmount * 0.10;
        }
        else {
            discount = 0;
        }
        double total = foodAmount + serviceCharge + gst - discount;
        displayBasicDetails();
        System.out.println("Table Number  : " + tableNumber);
        System.out.println("Service Charge: ₹" + serviceCharge);
        System.out.println("GST           : ₹" + gst);
        System.out.println("Discount      : ₹" + discount);
        System.out.println("Total Bill    : ₹" + total);
    }
}
class TakeAwayOrder extends FoodOrder {
    double packagingCharge;
    double gst;
    double discount;
    TakeAwayOrder(String customerName, String orderId, double foodAmount) {
        super(customerName, orderId, foodAmount);
    }
    void calculateBill() {
        System.out.println("\n===== TAKE-AWAY ORDER =====");
        packagingCharge = 50;
        gst = foodAmount * 0.05;
        if (foodAmount >= 1500) {
            discount = foodAmount * 0.05;
        }
        else {
            discount = 0;
        }
        double total = foodAmount + packagingCharge + gst - discount;
        displayBasicDetails();
        System.out.println("Packaging Fee : ₹" + packagingCharge);
        System.out.println("GST           : ₹" + gst);
        System.out.println("Discount      : ₹" + discount);
        System.out.println("Total Bill    : ₹" + total);
    }
}
public class FoodOrderAbstract {
    public static void main(String[] args) {
        FoodOrder order1 = new DineInOrder("Aditi","D101",2500,12);
        FoodOrder order2 = new TakeAwayOrder("Rahul","T202",1800);
        order1.calculateBill();
        order2.calculateBill();
    }
}
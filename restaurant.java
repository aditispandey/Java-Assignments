import java.util.Scanner;

class Restaurant {

    static int count = 0;

    void bill(float amount) {
        System.out.println("Dine-In Bill: " + amount);
        count++;
    }
    void bill(float amount, float pack) {
        System.out.println("Takeaway Bill: " + (amount + pack));
        count++;
    }

    void bill(float amount, float pack, float deliveryCharge) {
        System.out.println("Delivery Bill: " + (amount + pack + deliveryCharge));
        count++;
    }

    static void displayCount() {
        System.out.println("Total Bills Generated: " + count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Restaurant obj = new Restaurant();

        System.out.print("Enter Dine-In bill amount: ");
        float dine = sc.nextFloat();
        obj.bill(dine);

        System.out.print("Enter Takeaway bill amount: ");
        float takeaway = sc.nextFloat();

        System.out.print("Enter Packing charges: ");
        float pack = sc.nextFloat();

        obj.bill(takeaway, pack);

        System.out.print("Enter Delivery bill amount: ");
        float delivery = sc.nextFloat();

        System.out.print("Enter Packing charges: ");
        float pack2 = sc.nextFloat();

        System.out.print("Enter Delivery charges: ");
        float delCharge = sc.nextFloat();

        obj.bill(delivery, pack2, delCharge);

        displayCount();
    }
}
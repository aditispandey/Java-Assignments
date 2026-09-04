import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("========== ONLINE SHOPPING ==========");
            System.out.print("Enter product name: ");
            String product = sc.nextLine();
            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            try {
                System.out.print("Enter product quantity: ");
                int quantity = sc.nextInt();
                if (quantity <= 0) {
                    throw new ArithmeticException("Quantity must be greater than zero.");
                }
                double total = price * quantity;
                System.out.println("---------- ORDER DETAILS ----------");
                System.out.println("Product  : " + product);
                System.out.println("Price    : Rs. " + price);
                System.out.println("Quantity : " + quantity);
                System.out.println("Total    : Rs. " + total);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error while processing the quantity.");
            }
        } catch (Exception e) {
            System.out.println("Error while processing the order.");
        }
        System.out.println("====================================");
        sc.close();
    }
}
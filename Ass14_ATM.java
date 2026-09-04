import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 15000;
        try {
            System.out.println("========== ATM MACHINE ==========");
            try {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();
                if (amount <= 0) {
                    throw new ArithmeticException("Withdrawal amount must be greater than zero.");
                }
                if (amount > balance) {
                    throw new ArithmeticException("Insufficient balance.");
                }
                if (amount % 100 != 0) {
                    throw new ArithmeticException("Amount must be in multiples of 100.");
                }
                balance = balance - amount;
                System.out.println("Withdrawal successful!");
                System.out.println("Withdrawn Amount: Rs. " + amount);
                System.out.println("Remaining Balance: Rs. " + balance);
            } catch (ArithmeticException e) {
                System.out.println("ATM Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }
        } catch (Exception e) {
            System.out.println("ATM system error: " + e.getMessage());
        }
        System.out.println("=================================");
        sc.close();
    }
}

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correctPIN = 1234;
        int attempts = 3;
        boolean verified = false;
        System.out.println("======== ATM PIN VERIFICATION ========");
        while (attempts > 0 && !verified) {
            try {
                System.out.print("Enter your PIN: ");
                int pin = sc.nextInt();
                if (pin != correctPIN) {
                    throw new Exception("Invalid PIN!");
                }
                System.out.println("PIN Verified Successfully!");
                System.out.println("Access Granted.");
                verified = true;
            } catch (Exception e) {
                attempts--;
                System.out.println("Verification Failed!");
                System.out.println("Error: " + e.getMessage());
                if (attempts > 0) {
                    System.out.println("Attempts remaining: " + attempts);
                } else {
                    System.out.println("Maximum attempts exceeded.");
                    System.out.println("Access Denied.");
                }
            }
            finally {
                System.out.println("PIN verification process completed.\n");
            }
        }
        sc.close();
    }
}

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 15000;
        int choice = 0;
        try {
            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();
            if (pin != 1234) {
                throw new ArithmeticException("Incorrect PIN!");
            }
            do {
                System.out.println("\n========== ATM MENU ==========");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: Rs. " + balance);
                        break;
                    case 2:
                        try {
                            System.out.print("Enter withdrawal amount: Rs. ");
                            double amount = sc.nextDouble();
                            if (amount <= 0) {
                                throw new ArithmeticException("Amount must be greater than zero.");
                            }
                            if (amount > balance) {
                                throw new ArithmeticException("Insufficient balance.");
                            }
                            if (amount % 100 != 0) {
                                throw new ArithmeticException("Amount must be a multiple of Rs. 100.");
                            }
                            if (amount > 10000) {
                                throw new ArithmeticException("Maximum withdrawal limit is Rs. 10,000.");
                            }
                            balance -= amount;
                            System.out.println( "Withdrawal successful!");
                            System.out.println("Remaining Balance: Rs. " + balance);
                        }catch (ArithmeticException e) {
                            System.out.println("Withdrawal Error: " + e.getMessage());
                        }
                        catch (Exception e) {
                            System.out.println("Invalid withdrawal input!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: Rs. ");
                        double deposit = sc.nextDouble();
                        if (deposit <= 0) {
                            throw new ArithmeticException("Invalid deposit amount.");
                        }
                        balance += deposit;
                        System.out.println("Amount deposited: Rs. " + deposit);
                        System.out.println("Updated Balance: Rs. " + balance);
                        break;
                    case 4:
                        System.out.println("Exiting ATM Program");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } while (choice != 4);
        } catch (ArithmeticException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Input Error: Please enter valid data.");
        }
        finally {
            System.out.println("ATM session ended.");
            sc.close();
        }
    }
}

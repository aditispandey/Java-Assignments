import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correctPassword = 1234;
        int attempts = 3;
        boolean loginSuccessful = false;
        System.out.println("======== LOGIN SYSTEM ========");
        while (attempts > 0 && !loginSuccessful) {
            try {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                int password = sc.nextInt();
                sc.nextLine();
                if (password != correctPassword) {
                    throw new Exception("Invalid Password!");
                }
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, " + username + "!");
                System.out.println("\n----- MENU -----");
                System.out.println("1. View Profile");
                System.out.println("2. Change Password");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Profile displayed.");
                        break;
                    case 2:
                        System.out.println("Change password option selected.");
                        break;
                    case 3:
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
                loginSuccessful = true;
            } catch (Exception e) {
                attempts--;
                System.out.println("Login Failed!");
                System.out.println("Error: " + e.getMessage());
                if (attempts > 0) {
                    System.out.println("Attempts remaining: " + attempts);
                } else {
                    System.out.println("Maximum attempts exceeded.");
                    System.out.println("Account temporarily locked.");
                }
            } finally {
                System.out.println("Login attempt completed.");
            }
        }
        sc.close();
    }
}

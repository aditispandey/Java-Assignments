import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class DrivingLicense {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("===== DRIVING LICENSE SYSTEM =====");
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            if (age < 18) {
                throw new InvalidAgeException(
                    "Not eligible for a driving license."
                );
            }
            System.out.println("License Eligibility Verified!");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("You are eligible for a driving license.");
        } catch (InvalidAgeException e) {
            System.out.println("License Application Failed!");
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Driving license verification completed.");
            sc.close();
        }
    }
}

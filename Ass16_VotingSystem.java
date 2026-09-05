import java.util.Scanner;
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class VotingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("======== VOTING SYSTEM ========");
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            if (age < 18) {
                throw new InvalidAgeException(
                    "You are not eligible to vote. Age must be 18 or above."
                );
            }
            System.out.println("Voting Eligibility Verified!");
            System.out.println("Welcome, " + name + "!");
            System.out.println("You are eligible to vote.");
            System.out.println("\n----- Candidates -----");
            System.out.println("1. Candidate A");
            System.out.println("2. Candidate B");
            System.out.println("3. Candidate C");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vote cast for Candidate A.");
                    break;
                case 2:
                    System.out.println("Vote cast for Candidate B.");
                    break;
                case 3:
                    System.out.println("Vote cast for Candidate C.");
                    break;
                default:
                    System.out.println("Invalid candidate choice.");
            }
        } catch (InvalidAgeException e) {
            System.out.println("\nVoting Failed!");
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("\nVoting process completed.");
            sc.close();
        }
    }
}

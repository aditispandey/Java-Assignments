import java.io.*;
import java.util.Scanner;

public class PatientFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("patient.txt");
            System.out.print("Enter number of patients: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details of Patient " + i);
                System.out.print("Patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Patient Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Diagnosis: ");
                String diagnosis = sc.nextLine();
                fw.write("Patient ID: " + id + "\n");
                fw.write("Name: " + name + "\n");
                fw.write("Age: " + age + "\n");
                fw.write("Diagnosis: " + diagnosis + "\n");
                fw.write("-----------------------------\n");
            }
            fw.close();
            System.out.println("\nPatient details written successfully!");
            FileReader fr = new FileReader("patient.txt");
            System.out.println("\n===== PATIENT DETAILS =====");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
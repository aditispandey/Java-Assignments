import java.io.*;
import java.util.Scanner;

public class EmployeeFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("employee.txt");
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details of Employee " + i);
                System.out.print("Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Employee Name: ");
                String name = sc.nextLine();
                System.out.print("Department: ");
                String department = sc.nextLine();
                System.out.print("Designation: ");
                String designation = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();
                fw.write("Employee ID: " + id + "\n");
                fw.write("Name: " + name + "\n");
                fw.write("Department: " + department + "\n");
                fw.write("Designation: " + designation + "\n");
                fw.write("Salary: " + salary + "\n");
                fw.write("-----------------------------\n");
            }
            fw.close();
            System.out.println("\nEmployee details saved successfully!");
            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("\n===== EMPLOYEE DETAILS =====");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

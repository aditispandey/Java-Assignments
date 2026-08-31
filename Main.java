import faculty.Faculty;
import java.util.Scanner;
import student.Student;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("       COLLEGE MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.print("\nEnter number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter Student " + (i + 1) + " Details : \n");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter roll number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter course: ");
            String course = sc.nextLine();
            System.out.print("Enter semester: ");
            int semester = sc.nextInt();
            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            students[i] = new Student(
                name, rollNo, course, semester, cgpa, email
            );
        }
        System.out.print("\nEnter number of faculty members: ");
        int facultyCount = sc.nextInt();
        sc.nextLine();
        Faculty[] faculty = new Faculty[facultyCount];
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("\nEnter Faculty " + (i + 1) + " Details : \n");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter faculty ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter department: ");
            String department = sc.nextLine();
            System.out.print("Enter designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter years of experience: ");
            int experience = sc.nextInt();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            faculty[i] = new Faculty(name, id, department, designation,experience, salary);
        }
        System.out.println("\n\n==========================================");
        System.out.println("           COLLEGE RECORDS");
        System.out.println("==========================================");
        System.out.println("\n-------- STUDENT RECORDS --------");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
        System.out.println("\n-------- FACULTY RECORDS --------");
        for (int i = 0; i < facultyCount; i++) {
            faculty[i].displayFaculty();
        }
        sc.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;
public class StudentCourse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();
        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(sc.nextLine());
        }
        System.out.print("Enter course number to remove: ");
        int remove = sc.nextInt();
        if (remove >= 1 && remove <= courses.size()) {
            courses.remove(remove - 1);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\n--- REGISTERED COURSES ---\n");
        for (int i = 0; i < courses.size(); i++) {
            sb.append(i + 1).append(". ").append(courses.get(i)).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class TodoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> task = new ArrayList<>();
        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            task.add(sc.nextLine());
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\n--- TO-DO LIST ---\n");

        for (int i = 0; i < task.size(); i++) {
            sb.append(i + 1).append(". ").append(task.get(i)).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}



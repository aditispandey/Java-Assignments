import java.util.Scanner;
public class Employeepayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee details: ");
        System.out.print("Employee ID: ");
        String s1=sc.nextLine();
        System.out.print("Basic Salary: ");
        String s2=sc.nextLine();
        System.out.print("Bonus: ");
        String s3=sc.nextLine();
        System.out.print("Tax: ");
        String s4=sc.nextLine();

        Integer i=Integer.valueOf(s1);
        int id=i;

        Float s=Float.valueOf(s2);
        float bs=s;
        if(bs>1000000 || bs<0){
            System.out.println("Invalid salary");
        }

        Float b=Float.valueOf(s3);
        float bonus=b;
        if(b>100000 || bs<0){
            System.out.println("Invalid bonus");
        }

        Float t=Float.valueOf(s4);
        float tax=t;

        float total= bs+b;
        float net=total-((tax*total)/100);
        System.out.println("Net salary: "+net);
        sc.close();

    }
}

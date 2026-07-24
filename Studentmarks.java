import java.util.Scanner;
public class Studentmarks {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student marks out of 100");
        System.out.print("Physics:");
        String s1=sc.nextLine();
        System.out.print("Maths:");
        String s2=sc.nextLine();

        System.out.print("Chemistry:");
        String s3=sc.nextLine();

        System.out.print("English:");
        String s4=sc.nextLine();

        Integer mark1=Integer.valueOf(s1);
        Integer mark2=Integer.valueOf(s2);
        Integer mark3=Integer.valueOf(s3);
        Integer mark4=Integer.valueOf(s4);

        int m1=mark1;
        int m2=mark2;
        int m3=mark3;
        int m4=mark4;

        int total= m1+m2+m3+m4;
        System.out.println("Total marks: "+total +"/400");
        sc.close();
    }
}

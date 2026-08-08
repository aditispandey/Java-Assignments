import java.util.Scanner;
class Shape{
    void area(){
        System.out.println("Area: ");
    }
}
class Circle extends Shape{
    final float pi = 3.14f ;
    int radius;
    Circle(int r){
        this.radius = r;
    }
    void areac(){
        float ac = pi*radius*radius;
        System.out.println("Area of the Circle: "+ac);
    }
}
class Rectangle extends Shape{
    int length ;
    int breadth ;
    Rectangle(int l, int b){
        this.length = l;
        this.breadth = b;
    }
    void arear(){
        int ar = length * breadth;
        System.out.println("Area of the Rectangle: "+ar);
    }
}
public class Area{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        int r = sc.nextInt();
        System.out.print("Enter length: ");
        int l = sc.nextInt();
        System.out.print("Enter breadth: ");
        int b = sc.nextInt();
        Circle c = new Circle(r);
        c.area();
        c.areac();
        Rectangle rect = new Rectangle(l,b);
        rect.area();
        rect.arear();
        sc.close();
    }
}

public class Student1{
    String name;
    int age;
    int rollno;
    Student1(){
        System.out.println("Student Details: ");
    }
    Student1(String n,int a,int r){
        name=n;
        age=a;
        rollno=r;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Roll No.: "+rollno);
    }
    public static void main(String[] args){
        Student1 s=new Student1();
        Student1 s1=new Student1("Aditi",18,66);
        s1.display();
    }
}

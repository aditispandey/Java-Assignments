class Employee{
    String name = "Aditi Pandey";
    int id = 266;
    void display(){
        System.out.println("Employee Name: "+name);
        System.out.println("Employee ID: "+id);
    }
}
class Manager extends Employee{
    String department = "IT";
    void display(){
        System.out.println("Name: "+super.name);
        System.out.println("ID: "+super.id);
        System.out.println("Department: "+department);
    }
}
public class EmpManager {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display();
    }
}

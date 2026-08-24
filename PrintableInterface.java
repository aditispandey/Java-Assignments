interface Printable{
    void PrintDetails();
    void PrintHeader();
}
class Student implements Printable{
    int id;
    String name, course;
    double marks1, marks2, marks3;
    Student(int id, String name, String course, double marks1, double marks2, double marks3){
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }
    double calculateAverage(){
        return (marks1 + marks2 + marks3)/3;
    }
    String getGrade(){
        double average = calculateAverage();
            if (average >= 90){
                return "A+";
            }
            else if (average >= 80){
                return "A";
            }
            else if (average >= 70){
                return "B";
            }
            else if (average >= 60){
                return "C";
            }
            else if (average >= 40){
                return "D";
            }
            else {
                return "Fail";
            }
        }
    public void PrintHeader(){
            System.out.println("====== STUDENT DETAILS ======");
        }
    public void PrintDetails(){
        PrintHeader();
        System.out.println("Student ID    : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Course        : " + course);
        System.out.println("Marks 1       : " + marks1);
        System.out.println("Marks 1       : " + marks2);
        System.out.println("Marks 1       : " + marks3);
        System.out.println("Average Marks : " + calculateAverage());
        System.out.println("Grade         : " + getGrade());
    }
}
class Employee implements Printable{
    int id;
    String name, department;
    double salary, bonus;
    Employee(int id, String name, String department, double salary, double bonus){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.bonus = bonus;
    }
    double calculateTotalSalary(){
        return salary + bonus;
    }
    String salaryLevel(){
        double total_salary = calculateTotalSalary();
        if (total_salary > 100000){
            return "Senior - Level";
        }
        else if (total_salary >= 60000){
            return "Mid - Level";
        }
        else {
            return "Entry Level";
        }
    }
    public void PrintHeader(){
        System.out.println("====== EMPLOYEE DETAILS ======");
    }
    public void PrintDetails(){
        PrintHeader();
        System.out.println("Employee ID  : "+id);
        System.out.println("Name         : "+name);
        System.out.println("Basic Salary : "+ salary);
        System.out.println("Bonus        : " + bonus);
        System.out.println("Total Salary : " + calculateTotalSalary());
        System.out.println("Salary Level : "+ salaryLevel());
    }
}
public class PrintableInterface{
    public static void main(String[] args) {
        Printable s = new Student(266, "Aditi Pandey", "B.Tech CSE", 98,99,100);
        Printable e = new Employee(214, "Geeta Jaana", "CSE", 55000, 15000);
        s.PrintDetails();
        e.PrintDetails();
    }
}
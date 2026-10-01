import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Friends@3003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully.");
            Statement st = con.createStatement();

            // Create database
            String query = "create database if not exists studentdb";
            st.executeUpdate(query);
            System.out.println("Database created successfully.");

            // Connect to student database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", user,password);
            st = con.createStatement();

            // Create student table
            query = "create table if not exists student (" + "roll_no int primary key, " +"name varchar(50), " + "course varchar(50), " +"marks int)";
            st.executeUpdate(query);
            System.out.println("Student table created successfully.");

            // Insert student records
            query = "insert into student values " +
                    "(1, 'Aditi', 'BCA', 85)," +
                    "(2, 'Rahul', 'BCA', 78)," +
                    "(3, 'Sneha', 'BCA', 92)";
            st.executeUpdate(query);
            System.out.println("Student records inserted successfully.");

            // Retrieve student records
            query = "select * from student";
            ResultSet rs = st.executeQuery(query);
            System.out.println("\nStudent Records:");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getInt("marks"));
                System.out.println();
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

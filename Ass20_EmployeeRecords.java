import java.sql.*;

public class EmployeeRecords {

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
            String query = "create database if not exists employeedb";
            st.executeUpdate(query);
            System.out.println("Database created successfully.");

            // Connect to database
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedb",
                user,
                password
            );
            st = con.createStatement();

            // Create table
            query = "create table if not exists employee (" + "emp_id int primary key, " + "name varchar(50), " + "department varchar(50), " + "salary double)";
            st.executeUpdate(query);
            System.out.println("Employee table created successfully.");

            // Insert records
            query = "insert into employee values " +
                    "(101, 'Aditi', 'IT', 50000)," +
                    "(102, 'Rahul', 'HR', 45000)," +
                    "(103, 'Sneha', 'Finance', 55000)";
            st.executeUpdate(query);
            System.out.println("Employee records inserted successfully.");

            // Update
            query = "update employee set salary = 60000 where emp_id = 101";
            st.executeUpdate(query);
            System.out.println("Employee record updated successfully.");

            // Delete
            query = "delete from employee where emp_id = 103";
            st.executeUpdate(query);
            System.out.println("Employee record deleted successfully.");

            // READ
            query = "select * from employee";
            ResultSet rs = st.executeQuery(query);
            System.out.println("\nEmployee Records:");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("-----------------------------");
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

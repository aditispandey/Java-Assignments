import java.sql.*;

public class JDBCstatus {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Friends@3003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection( url, user, password );
            System.out.println("MySQL Connected Successfully.");
            Statement st = con.createStatement();

            // Create student database
            String query = "create database if not exists studentdb";
            st.executeUpdate(query);
            System.out.println("Student database created successfully.");

            // Connect to student database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", user, password);
            System.out.println("Student database connected successfully.");

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

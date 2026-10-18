import java.sql.*;
import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/";
        String dbUser = "root";
        String dbPassword = "Friends@3003";
        try {
            Connection con = DriverManager.getConnection(
                url, dbUser, dbPassword);
            Statement st = con.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS login_db");
            st.executeUpdate("USE login_db");
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "username VARCHAR(50) PRIMARY KEY, " +
                "password VARCHAR(100) NOT NULL)");
            String insertQuery =
                "INSERT IGNORE INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insert = con.prepareStatement(insertQuery);
            insert.setString(1, "admin");
            insert.setString(2, "admin123");
            insert.executeUpdate();
            insert.setString(1, "student");
            insert.setString(2, "stud123");
            insert.executeUpdate();
            System.out.println("Database and table created successfully.");
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            String query = "SELECT username FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + rs.getString("username"));
            } else {
                System.out.println("Invalid username or password.");
            }
            rs.close();
            ps.close();
            insert.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        sc.close();
    }
}
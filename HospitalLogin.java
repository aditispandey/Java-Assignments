import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/";
        String dbUser = "root";
        String dbPassword = "Friends@3003";
        try {
            Connection con = DriverManager.getConnection(
                url, dbUser, dbPassword
            );
            Statement st = con.createStatement();
            st.executeUpdate(
                "CREATE DATABASE IF NOT EXISTS hospital_db"
            );
            st.executeUpdate("USE hospital_db");
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS hospital_staff (" +
                "login_id VARCHAR(50) PRIMARY KEY, " +
                "password VARCHAR(100) NOT NULL, " +
                "staff_name VARCHAR(100) NOT NULL, " +
                "role VARCHAR(20) NOT NULL)"
            );
            String insertQuery =
                "INSERT IGNORE INTO hospital_staff " +
                "(login_id, password, staff_name, role) VALUES (?, ?, ?, ?)";
            PreparedStatement insert =
                con.prepareStatement(insertQuery);
            insert.setString(1, "doc101");
            insert.setString(2, "doc123");
            insert.setString(3, "Dr. Rahul");
            insert.setString(4, "doctor");
            insert.executeUpdate();
            insert.setString(1, "nurse101");
            insert.setString(2, "nurse123");
            insert.setString(3, "Priya Sharma");
            insert.setString(4, "nurse");
            insert.executeUpdate();
            insert.setString(1, "admin101");
            insert.setString(2, "admin123");
            insert.setString(3, "Hospital Admin");
            insert.setString(4, "admin");
            insert.executeUpdate();
            System.out.println("Hospital database created successfully.");
            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            String query =
                "SELECT staff_name, role FROM hospital_staff " +
                "WHERE login_id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loginId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("staff_name");
                String role = rs.getString("role");
                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + name);
                if (role.equalsIgnoreCase("doctor")) {
                    System.out.println("Access Granted: Doctor Dashboard");
                } else if (role.equalsIgnoreCase("nurse")) {
                    System.out.println("Access Granted: Nurse Dashboard");
                } else if (role.equalsIgnoreCase("admin")) {
                    System.out.println("Access Granted: Hospital Admin Dashboard");
                } else {
                    System.out.println("Access Denied: Invalid role.");
                }
            } else {
                System.out.println("Authentication failed!");
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access Denied.");
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

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Friends@3003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully.");
            Statement st = con.createStatement();
            System.out.println("Statement Created Successfully.");
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
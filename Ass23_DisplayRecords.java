import java.sql.*;

public class DisplayRecords {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root","password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rollno"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("--------------------");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

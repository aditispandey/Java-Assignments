import java.sql.*;

public class ProductRecords {
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
            String query = "create database if not exists productdb";
            st.executeUpdate(query);
            System.out.println("Database created successfully.");

            // Connect to product database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb" , user, password);
            st = con.createStatement();

            // Create product table
            query = "create table if not exists product (" + "product_id int primary key, " + "product_name varchar(50), " + "quantity int, " + "price double)";
            st.executeUpdate(query);
            System.out.println("Product table created successfully.");

            // Insert product records
            query = "insert into product values " +
                    "(1, 'Laptop', 10, 55000)," +
                    "(2, 'Mouse', 25, 800)," +
                    "(3, 'Keyboard', 15, 1500)";
            st.executeUpdate(query);
            System.out.println("Product records inserted successfully.");

            // SELECT query
            query = "select * from product";
            ResultSet rs = st.executeQuery(query);
            System.out.println("\nProduct Details:");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Product Name: " + rs.getString("product_name"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("-----------------------------");
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
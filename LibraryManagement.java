import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibraryManagement extends JFrame {
    JTextField idField, titleField, authorField, yearField;
    JTable table;
    DefaultTableModel model;
    Connection con;
    LibraryManagement() {
        setTitle("Library Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        connectDatabase();
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Book Details"));
        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();
        yearField = new JTextField();
        form.add(new JLabel("Book ID:"));
        form.add(idField);
        form.add(new JLabel("Book Title:"));
        form.add(titleField);
        form.add(new JLabel("Author:"));
        form.add(authorField);
        form.add(new JLabel("Publication Year:"));
        form.add(yearField);
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton deleteButton = new JButton("Delete Book");
        JButton clearButton = new JButton("Clear Fields");
        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(deleteButton);
        buttons.add(clearButton);
        model = new DefaultTableModel(new String[]{"Book ID", "Title", "Author", "Year"}, 0);
        table = new JTable(model);
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());
        viewBooks();
        setVisible(true);
    }

    void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection setup = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Friends@3003");
            Statement st = setup.createStatement();
            st.executeUpdate("create database if not exists library_management");
            st.close();
            setup.close();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root", "Friends@3003");
            Statement st2 = con.createStatement();
            st2.executeUpdate(
                "create table if not exists books (" + "book_id int primary key, " +
                "title varchar(100) not null, " +"author varchar(100) not null, " +
                "publication_year int)");
            st2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }

    void addBook() {
        try {
            if (con == null || con.isClosed()) {
                throw new SQLException("Database is not connected.");
            }
            int id = Integer.parseInt(idField.getText().trim());
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String yearText = yearField.getText().trim();
            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter book title and author.");
                return;
            }
            Integer year = yearText.isEmpty()
                ? null : Integer.valueOf(yearText);
            PreparedStatement ps = con.prepareStatement("insert into books values (?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            if (year == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, year);
            }
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(this, "Book added successfully.");
            clearFields();
            viewBooks();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Book ID and year must be numbers.");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Book ID already exists.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void viewBooks() {
        if (con == null) return;
        try {
            model.setRowCount(0);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books order by book_id");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getObject("publication_year")
                });
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteBook() {
        try {
            if (con == null || con.isClosed()) {
                throw new SQLException("Database is not connected.");
            }
            String idText = idField.getText().trim();
            if (idText.isEmpty()) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Enter a Book ID or select a book.");
                    return;
                }
                idText = model.getValueAt(row, 0).toString();
            }
            int id = Integer.parseInt(idText);
            PreparedStatement ps = con.prepareStatement("delete from books where book_id = ?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(this, count > 0? "Book deleted successfully.": "Book ID not found.");
            clearFields();
            viewBooks();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        yearField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagement());
    }
}

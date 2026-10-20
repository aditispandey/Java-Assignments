import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookIssueTracking extends JFrame {
    JTextField idField, studentField, issueField, returnField;
    JTable table;
    DefaultTableModel model;
    Connection con;
    BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        connectDatabase();
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Book Issue Details"));
        idField = new JTextField();
        studentField = new JTextField();
        issueField = new JTextField();
        returnField = new JTextField();
        form.add(new JLabel("Book ID:"));
        form.add(idField);
        form.add(new JLabel("Student Name:"));
        form.add(studentField);
        form.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        form.add(issueField);
        form.add(new JLabel("Return Date (YYYY-MM-DD):"));
        form.add(returnField);
        JButton addButton = new JButton("Add Record");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");
        JButton clearButton = new JButton("Clear Fields");
        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(deleteButton);
        buttons.add(clearButton);
        model = new DefaultTableModel(
            new String[]{"Book ID", "Student Name", "Issue Date", "Return Date"}, 0);
        table = new JTable(model);
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());
        clearButton.addActionListener(e -> clearFields());
        viewRecords();
        setVisible(true);
    }

    void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection setup = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Friends@3003");
            Statement st = setup.createStatement();
            st.executeUpdate("create database if not exists library_db");
            st.close();
            setup.close();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root", "Friends@3003");
            Statement st2 = con.createStatement();
            st2.executeUpdate(
                "create table if not exists book_issue (" +
                "book_id int primary key, " +
                "student_name varchar(100) not null, " +
                "issue_date date not null, " +
                "return_date date)"
            );
            st2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Database Error: " + e.getMessage()
            );
        }
    }

    void addRecord() {
        try {
            if (con == null || con.isClosed()) {
                throw new SQLException("Database is not connected.");
            }
            int id = Integer.parseInt(idField.getText().trim());
            String student = studentField.getText().trim();
            String issue = issueField.getText().trim();
            String ret = returnField.getText().trim();
            if (student.isEmpty() || issue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Student name and issue date are required.");
                return;
            }
            Date issueDate = Date.valueOf(issue);
            Date returnDate = ret.isEmpty() ? null : Date.valueOf(ret);
            if (returnDate != null && returnDate.before(issueDate)) {
                JOptionPane.showMessageDialog(this, "Return date cannot be before issue date.");
                return;
            }
            PreparedStatement ps = con.prepareStatement("insert into book_issue values (?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, student);
            ps.setDate(3, issueDate);
            if (returnDate == null) {
                ps.setNull(4, Types.DATE);
            } else {
                ps.setDate(4, returnDate);
            }
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(this, "Record added successfully.");
            clearFields();
            viewRecords();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Book ID must be a number.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Enter dates in YYYY-MM-DD format.");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "This Book ID already exists.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void viewRecords() {
        if (con == null)
            return;
        try {
            model.setRowCount(0);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_issue order by book_id");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("student_name"),
                    rs.getDate("issue_date"),
                    rs.getDate("return_date")
                });
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteRecord() {
        try {
            if (con == null || con.isClosed()) {
                throw new SQLException("Database is not connected.");
            }
            String idText = idField.getText().trim();
            if (idText.isEmpty()) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Enter a Book ID or select a record.");
                    return;
                }
                idText = model.getValueAt(row, 0).toString();
            }
            int id = Integer.parseInt(idText);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete Book ID " + id + "?","Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION)
                return;
            PreparedStatement ps = con.prepareStatement("delete from book_issue where book_id = ?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(this, count > 0 ? "Record deleted successfully." : "Book ID not found.");
            clearFields();
            viewRecords();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void clearFields() {
        idField.setText("");
        studentField.setText("");
        issueField.setText("");
        returnField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookIssueTracking());
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistration extends JFrame implements ActionListener {
    JTextField tfId, tfName, tfDepartment, tfSalary;
    JButton btnSubmit, btnClear;
    EmployeeRegistration() {
        setTitle("Employee Registration Form");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Employee ID:"));
        tfId = new JTextField();
        add(tfId);

        add(new JLabel("Name:"));
        tfName = new JTextField();
        add(tfName);

        add(new JLabel("Department:"));
        tfDepartment = new JTextField();
        add(tfDepartment);

        add(new JLabel("Salary:"));
        tfSalary = new JTextField();
        add(tfSalary);

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        add(btnSubmit);
        add(btnClear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String id = tfId.getText();
            String name = tfName.getText();
            String department = tfDepartment.getText();
            String salary = tfSalary.getText();

            JOptionPane.showMessageDialog(this,
                "Employee Registration Details\n\n" +
                "Employee ID: " + id +
                "\nName: " + name +
                "\nDepartment: " + department +
                "\nSalary: " + salary,
                "Employee Details",
                JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == btnClear) {
            tfId.setText("");
            tfName.setText("");
            tfDepartment.setText("");
            tfSalary.setText("");
        }
    }

    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}

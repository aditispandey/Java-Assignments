import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton add, subtract;

    Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        num1 = new JTextField();
        num2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add = new JButton("Addition");
        subtract = new JButton("Subtraction");

        add.addActionListener(this);
        subtract.addActionListener(this);

        add(l1);
        add(num1);
        add(l2);
        add(num2);
        add(l3);
        add(result);
        add(add);
        add(subtract);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());

        if (e.getSource() == add) {
            result.setText(String.valueOf(a + b));
        }
        if (e.getSource() == subtract) {
            result.setText(String.valueOf(a - b));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
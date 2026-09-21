import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankBalance extends JFrame implements ActionListener {
    JTextField initialBalance, amount, balance;
    JButton deposit, withdrawal, checkBalance;

    double currentBalance;

    BankBalance() {
        setTitle("Bank Balance Calculator");
        setSize(450, 350);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Initial Balance:");
        JLabel l2 = new JLabel("Transaction Amount:");
        JLabel l3 = new JLabel("Current Balance:");

        initialBalance = new JTextField();
        amount = new JTextField();
        balance = new JTextField();

        balance.setEditable(false);

        deposit = new JButton("Deposit");
        withdrawal = new JButton("Withdrawal");
        checkBalance = new JButton("Check Balance");

        deposit.addActionListener(this);
        withdrawal.addActionListener(this);
        checkBalance.addActionListener(this);

        add(l1);
        add(initialBalance);
        add(l2);
        add(amount);
        add(l3);
        add(balance);
        add(deposit);
        add(withdrawal);
        add(checkBalance);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            currentBalance = Double.parseDouble(initialBalance.getText());
            double depositAmount = Double.parseDouble(amount.getText());

            currentBalance = currentBalance + depositAmount;
            balance.setText(String.valueOf(currentBalance));
            initialBalance.setText(String.valueOf(currentBalance));
        }

        if (e.getSource() == withdrawal) {
            currentBalance = Double.parseDouble(initialBalance.getText());
            double withdrawalAmount = Double.parseDouble(amount.getText());

            if (withdrawalAmount <= currentBalance) {
                currentBalance = currentBalance - withdrawalAmount;
                balance.setText(String.valueOf(currentBalance));
                initialBalance.setText(String.valueOf(currentBalance));
            } else {
                balance.setText("Insufficient Balance");
            }
        }

        if (e.getSource() == checkBalance) {
            currentBalance = Double.parseDouble(initialBalance.getText());
            balance.setText(String.valueOf(currentBalance));
        }
    }

    public static void main(String[] args) {
        new BankBalance();
    }
}
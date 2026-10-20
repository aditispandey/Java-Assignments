class BankAccount {
    int balance = 1000;
    synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

class DepositTask implements Runnable {
    BankAccount account;
    DepositTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(500);
        }
    }
}

class WithdrawTask implements Runnable {
    BankAccount account;
    WithdrawTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.withdraw(300);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new DepositTask(account));
        Thread t2 = new Thread(new WithdrawTask(account));
        t1.start();
        t2.start();
    }
}

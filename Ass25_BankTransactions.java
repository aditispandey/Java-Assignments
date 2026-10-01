class BankAccount {
    int balance = 1000 ;
    boolean depositTurn = true ;
    synchronized void deposit(int amount){
        while (!depositTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        balance = balance + amount ;
        System.out.println("Deposited : " + amount + " | Balance : " + balance) ;
        depositTurn = false ;
        notify();
    }
    synchronized void withdraw(int amount) {
        while (depositTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (balance >= amount) {
            balance -= amount ;
            System.out.println("Withdrawn : " + amount + " | Balance : " + balance);
        }
        else {
            System.out.println("Insufficient Balance!");
        }
        depositTurn = true ;
        notify();
    }
}

class DepositThread extends Thread {
    BankAccount account ;
    DepositThread(BankAccount account) {
        this.account = account;
    }
    public void run(){
        for(int i = 1; i<=5; i++){
            account.deposit(500);
        }
    }
}

class WithdrawThread extends Thread {
    BankAccount account ;
    WithdrawThread(BankAccount account){
        this.account = account;
    }
    public void run(){
        for(int i = 1; i<=5; i++){
            account.withdraw(300);
        }
    }
}

public class BankTransactions {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        DepositThread d = new DepositThread(account);
        WithdrawThread w = new WithdrawThread(account);
        d.start();
        w.start();
    }
}

interface BankOperations{
    void deposit(double amount);
    void withdraw(double amount);
    void displayBankAccInfo();
}
class BankAccount implements BankOperations{
    final long AccountNumber;
    String AccountHolder;
    double balance;
    BankAccount(long AccountNumber, String AccountHolder, double balance){
        this.AccountNumber = AccountNumber;
        this.AccountHolder = AccountHolder;
        this.balance = balance;
    }
    public void deposit(double amount){
        if (amount>0){
            balance = balance + amount;
            System.out.println("Amount deposited: "+amount);
        }
        else {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount < balance){
            balance = balance - amount;
            System.out.println("Amount Withdrawn: "+amount);
        }
        else{
            System.out.println("Insufficient balance or invalid withdrawal amount");
        }
    }
    public void displayBankAccInfo(){
        System.out.println();
        System.out.println("--- Account Details ---");
        System.out.println("Account Number  : "+AccountNumber);
        System.out.println("Account Holder  : "+ AccountHolder);
        System.out.println("Account Balance : "+balance);
        System.out.println();
    }
}
public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(70122266, "Aditi Pandey", 200000);
        b.displayBankAccInfo();
        b.deposit(50000);
        b.withdraw(15000);
        b.displayBankAccInfo();
    }
}

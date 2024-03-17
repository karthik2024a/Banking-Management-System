import java.util.*;
public class Account {
    private String accountNumber;
    private String customerName;
    private double balance;
    private Transaction lastTransaction;

    public Account(String accountNumber, String customerName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialDeposit;
        this.lastTransaction = new Transaction("Initial Deposit", initialDeposit);
    }

    public void deposit(double amount) {
        balance += amount;
        lastTransaction = new Transaction("Deposit", amount);
        System.out.println("Deposit successful. \nNew balance: " + balance);
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            lastTransaction = new Transaction("Transfer to " + recipient.customerName, amount);
            System.out.println("Transfer successful. \nNew balance: " + balance);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance for " + customerName + ": " + balance);
    }

    public void displayLastTransaction() {
        System.out.println("Last Transaction: " + lastTransaction);
    }
}


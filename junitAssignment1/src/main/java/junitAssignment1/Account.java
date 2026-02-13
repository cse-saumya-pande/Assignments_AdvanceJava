package junitAssignment1;

public class Account {

    private int accountNumber;
    private String accountHolderName;
    private double currentBalance;

    // Constructor
    public Account(int accountNumber, String accountHolderName, double currentBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.currentBalance = currentBalance;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    // Setter
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
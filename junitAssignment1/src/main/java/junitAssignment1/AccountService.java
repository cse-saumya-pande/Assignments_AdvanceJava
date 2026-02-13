package junitAssignment1;


public class AccountService {

    // 1️⃣ Deposit
    public double deposit(Account acc, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than 0");
        }

        double updatedBalance =
                acc.getCurrentBalance() + amount;

        acc.setCurrentBalance(updatedBalance);

        return updatedBalance;
    }

    // 2️⃣ Withdraw
    public boolean withdraw(Account acc, double amount) {

        if (amount <= acc.getCurrentBalance()) {

            double updatedBalance =
                    acc.getCurrentBalance() - amount;

            acc.setCurrentBalance(updatedBalance);
            return true;
        }

        return false;
    }

    // 3️⃣ Minimum Balance Check
    public boolean hasMinimumBalance(Account acc) {

        return acc.getCurrentBalance() >= 1000;
    }
}
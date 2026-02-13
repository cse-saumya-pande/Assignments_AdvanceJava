package junitAssignment1Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junitAssignment1.Account;
import junitAssignment1.AccountService;

public class AccountServiceTest {

    private AccountService service;
    private Account account;

    @BeforeEach
    void setup() {

        service = new AccountService();

        // Initial Balance = 5000
        account = new Account(101, "Ritika", 5000);
    }

    // ✅ Test Case 1 — Deposit
    @Test
    void testDepositAmount() {

        double updatedBalance =
                service.deposit(account, 1000);

        assertEquals(6000, updatedBalance);
    }

    // ✅ Test Case 2 — Withdraw
    @Test
    void testWithdrawAmount() {

        service.withdraw(account, 2000);

        double updatedBalance =
                account.getCurrentBalance();

        assertEquals(3000, updatedBalance);
    }

    // ✅ Test Case 3 — Withdraw > Balance
    @Test
    void testWithdrawMoreThanBalance() {

        boolean result =
                service.withdraw(account, 6000);

        assertFalse(result);
    }

    // ✅ Test Case 4 — Minimum Balance
    @Test
    void testMinimumBalanceValidation() {

        boolean result =
                service.hasMinimumBalance(account);

        assertTrue(result);
    }
}
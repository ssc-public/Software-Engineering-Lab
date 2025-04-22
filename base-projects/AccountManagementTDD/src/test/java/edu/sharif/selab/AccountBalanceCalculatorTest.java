package edu.sharif.selab;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountBalanceCalculatorTest {
    @BeforeEach
    void setUp() {
        // Clear transaction history before each test
        AccountBalanceCalculator.clearTransactionHistory();
    }

    @Test
    public void testEmptyTransactionList() {
        int balance = AccountBalanceCalculator.calculateBalance(Collections.emptyList());
        assertEquals(0, balance);
    }

    @Test
    void testOnlyDeposits() {
        int balance = AccountBalanceCalculator.calculateBalance(Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 100),
                new Transaction(TransactionType.DEPOSIT, 200)
        ));
        assertEquals(300, balance);
    }


    @Test
    void testMixedTransactions() {
        int balance = AccountBalanceCalculator.calculateBalance(Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 200),
                new Transaction(TransactionType.WITHDRAWAL, 100),
                new Transaction(TransactionType.DEPOSIT, 50)
        ));
        assertEquals(150, balance);
    }
    @Test
    void testZeroAmountTransaction() {
        int balance = AccountBalanceCalculator.calculateBalance(Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 0),
                new Transaction(TransactionType.WITHDRAWAL, 0)
        ));
        assertEquals(0, balance);
    }


    @Test
    void testTransactionHistoryShouldNotBeNull() {
        List<Transaction> history = AccountBalanceCalculator.getTransactionHistory();

        assertNotNull(history, "Transaction history should not be null");
    }

    @Test
    void testTransactionHistoryShouldBeEmptyBeforeCalculatingBalance() {
        // Ensure the transaction history is empty before calling calculateBalance
        List<Transaction> history = AccountBalanceCalculator.getTransactionHistory();
        assertTrue(history.isEmpty(), "Transaction history should be empty before calculating balance");
    }

    @Test
    void testTransactionHistoryAfterDeposits() {
        // Perform deposits
        List<Transaction> transactions = Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 100),
                new Transaction(TransactionType.DEPOSIT, 200)
        );

        // Calculate balance, which will also add transactions to the history
        AccountBalanceCalculator.calculateBalance(transactions);

        // Ensure the transaction history contains the correct transactions
        List<Transaction> history = AccountBalanceCalculator.getTransactionHistory();
        assertEquals(2, history.size(), "Transaction history should contain 2 transactions");

        // Check if the transactions are correctly recorded
        assertTrue(history.containsAll(transactions), "Transaction history should contain both deposit transactions");
    }

    @Test
    void testTransactionHistoryAfterDepositsAndWithdrawals() {
        // Perform deposits and withdrawals
        List<Transaction> transactions = Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 200),
                new Transaction(TransactionType.WITHDRAWAL, 50),
                new Transaction(TransactionType.DEPOSIT, 100)
        );

        // Calculate balance
        AccountBalanceCalculator.calculateBalance(transactions);

        // Ensure the transaction history contains the correct transactions
        List<Transaction> history = AccountBalanceCalculator.getTransactionHistory();
        assertEquals(3, history.size(), "Transaction history should contain 3 transactions");

        // Check if the transactions are correctly recorded
        assertTrue(history.containsAll(transactions), "Transaction history should contain all deposit and withdrawal transactions");
    }

    @Test
    void testTransactionHistoryShouldContainOnlyLastCalculationTransactions() {
        // Perform first calculation with some transactions
        List<Transaction> firstTransactions = Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 100),
                new Transaction(TransactionType.WITHDRAWAL, 50)
        );

        AccountBalanceCalculator.calculateBalance(firstTransactions);

        // Ensure the transaction history contains the correct transactions from the first calculation
        List<Transaction> historyAfterFirstCalc = AccountBalanceCalculator.getTransactionHistory();
        assertEquals(2, historyAfterFirstCalc.size(), "Transaction history should contain 2 transactions after the first calculation");
        assertTrue(historyAfterFirstCalc.containsAll(firstTransactions), "Transaction history should contain the first set of transactions");

        // Perform second calculation with different transactions
        List<Transaction> secondTransactions = Arrays.asList(
                new Transaction(TransactionType.DEPOSIT, 200),
                new Transaction(TransactionType.WITHDRAWAL, 150)
        );

        AccountBalanceCalculator.calculateBalance(secondTransactions);

        // Ensure the transaction history only contains transactions from the second calculation
        List<Transaction> historyAfterSecondCalc = AccountBalanceCalculator.getTransactionHistory();
        assertEquals(2, historyAfterSecondCalc.size(), "Transaction history should contain 2 transactions after the second calculation");
        assertTrue(historyAfterSecondCalc.containsAll(secondTransactions), "Transaction history should contain the second set of transactions");
        assertFalse(historyAfterSecondCalc.containsAll(firstTransactions), "Transaction history should not contain the first set of transactions after the second calculation");
    }
}

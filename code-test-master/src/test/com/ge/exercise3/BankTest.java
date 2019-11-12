package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001", "Checking", 100.0f);
        Account account1 = new Account("002", "Checking", 100.0f);
        Account account2 = new Account("003", "Savings");
        Account account3 = new Account("004", "Checking");
        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        assertEquals(4, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawTest1() {
        Account account = new Account("004", "Checking", 200.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(100.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawTest2() {
        Account account = new Account("005", "Savings", 200.0f);
        bank.addAccount(account);
        //bank.withdrawFromAccount("005", 201.0f);
        bank.withdrawFromAccount("005", 101.0f);
        assertEquals(99.0f, account.getBalance(), 0.01);
    }

    @Test
    public void currentHoldingsSumTest() {
        Bank bank = new Bank();
        Account account = new Account("001", "Checking", 100.0f);
        Account account1 = new Account("002", "Checking", 2009.0f);
        Account account2 = new Account("003", "Savings");
        Account account3 = new Account("004", "Checking");
        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        assertEquals(2109.0f, bank.currentHoldingsSum(), 0.0f);
    }

    @Test
    public void nextMonthProfitOrLossTest() {
        Bank bank = new Bank();
        Account account = new Account("001", "Checking", 100.0f);
        Account account1 = new Account("002", "Savings", 2009.0f);
        account.setMonthlyFee(10.0f);
        account.setMonthlyInterestRate(1.05f);
        account1.setMonthlyInterestRate(1.15f);
        bank.addAccount(account);
        bank.addAccount(account1);
        assertEquals("bank has a total loss of 296.34985", bank.nextMonthProfitOrLoss());
    }

    @Test
    public void nextMonthProfitOrLossTest1() {
        Bank bank = new Bank();
        Account account3 = new Account("003", "Checking", 100.0f);
        Account account4 = new Account("004", "Savings", 200.0f);
        account3.setMonthlyFee(90.0f);
        account4.setMonthlyFee(10.0f);
        bank.addAccount(account3);
        bank.addAccount(account4);
        assertEquals("bank has a total profit of 98.0", bank.nextMonthProfitOrLoss());
    }
}
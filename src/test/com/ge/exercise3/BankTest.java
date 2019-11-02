package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
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
    public void currentHoldingTest() {
    	Account account = new Account("005", "Checking", 200.0f);
    	Account account2 = new Account("006", "Savings", 100.0f);
    	bank.addAccount(account);
    	bank.addAccount(account2);
    	assertEquals(300, bank.getCurrentHoldings(), 0.00);
    }
    
    @Test
    public void projectProfitTest() {
    	Account account = new Account("007", "Checking", 200.0f);
    	account.setMonthlyFee(30.0f);
    	bank.addAccount(account);
    	Account account2 = new Account("008", "Savings", 100.0f);
    	bank.addAccount(account2);
    	assertEquals("Bank is making a profit", bank.projectProfitOrLoss());
    }
    
    @Test
    public void projectLossTest() {
    	Account account = new Account("009", "Checking", 200.0f);
    	account.setMonthlyFee(1.0f);
    	bank.addAccount(account);
    	Account account2 = new Account("010", "Savings", 100.0f);
    	account2.setMonthlyInterestRate(1.05f);
    	bank.addAccount(account2);
    	assertEquals("Bank is making a loss", bank.projectProfitOrLoss());
    }
    
}
package com.ge.exercise3;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank {

	private static final Logger logger = LogManager.getLogger(Bank.class);
	private Map<String, Account> accountMap;

	public Bank() {
		accountMap = new HashMap<>();
	}

	public Account getAccount(String accountNumber) {
		return accountMap.get(accountNumber);
	}

	public void addAccount(Account account) {
		accountMap.put(account.getAccountNumber(), account);
	}

	public void depositToAccount(String accountNumber, float amount) {
		getAccount(accountNumber).deposit(amount);
	}

	public void withdrawFromAccount(String accountNumber, float amount) {
		getAccount(accountNumber).withdraw(amount);
	}

	public int numAccounts() {
		return accountMap.size();
	}

	public float getCurrentHoldings() {
		int totalHoldings = 0;
		for (Map.Entry<String, Account> account : accountMap.entrySet()) {
			totalHoldings += account.getValue().getBalance();
		}

		return totalHoldings;
	}

	public String projectProfitOrLoss() {
		int total = 0;

		for (Map.Entry<String, Account> account : accountMap.entrySet()) {
			total += getAccount(account.getKey()).getBalance() - getAccount(account.getKey()).valueNextMonth();
		}

		if (total < 0) {
			return "Bank is making a loss";
		} else if (total > 0) {
			return "Bank is making a profit";
		} else {
			return "Bank is not making any profit or loss";
		}
	}
}

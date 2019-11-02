package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {

	private static final Logger logger = LogManager.getLogger(Account.class);

	private float monthlyInterestRate = 1.01f;
	private float monthlyFee = 0.0f;

	private String accountNumber;
	private String accountType;
	private float balance;

	public Account(String accountNumber, String accountType, float balance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		if (accountType == "Checking") {
			monthlyInterestRate = 1.0f;
		}
	}

	public Account(String accountNumber, String accountType) {
		this(accountNumber, accountType, 0.0f);
	}

	public Account(String accountNumber) {
		this(accountNumber, "Savings", 0.0f);
	}

	public float valueNextMonth() {
		return (balance * monthlyInterestRate) - monthlyFee;
	}

	@Override
	public String toString() {
		if (accountType == "Checking") {
			if (monthlyFee == 0.0f) {
				return "No fee checking account #" + accountNumber;
			} else {
				return "Checking account #" + accountNumber;
			}
		} else {
			if (monthlyInterestRate > 1.01) {
				if (monthlyFee == 0.0f) {
					return "High interest no fee savings account #" + accountNumber;
				} else {
					return "High interest savings account #" + accountNumber;
				}
			} else {
				if (monthlyFee == 0.0f) {
					return "No fee savings account #" + accountNumber;
				} else {
					return "Savings account #" + accountNumber;
				}
			}
		}
	}

	public void deposit(float amount) {
		balance += amount;
	}

	public String withdraw(float amount) {
		if (this.accountType == "Checking" && (balance - amount) >= -100) {
			balance -= amount;
			return "checking " + balance;
		} else if (accountType == "Savings" && (balance - amount) >= 0) {
			balance -= amount;
			return "savings " + balance;
		} else {
			return "Insufficient Balance";
		}
	}

	public float getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(float monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public float getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(float monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	void setBalance(float balance) {
		this.balance = balance;
	}
}

package com.meritamerica.assignment3;

//package com.meritamerica.assignment3;

import java.util.Date;


//static BankAccount readFromString(String accountData) throws ParseException
//Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
//String writeToString()
//

public class BankAccount {
	
	protected double balance;
	protected double interestRate;
	protected long accountNumber;
	protected CDOffering offering;
	protected Date openDate;
	
	
	public BankAccount() {
		
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}

	public BankAccount(double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.openDate = accountOpenedOn;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}

	public BankAccount(CDOffering offering, double balance) {
		this.balance = balance;
		this.offering = offering;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = accountNumber;
	}
	
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public Date getOpenedOn() {
		return openDate;
	}
	
	
	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -=amount;
			return true;
		}else {
			System.out.println("Incorrect amount or exceeding balance.");
			return false;
			}
	}
	
	public boolean deposit (double amount) {
		if(amount > 0) {
			balance +=amount;
			return true;
		}else {
			System.out.println("Can't be zero or negative.");
			return false;
		}
	}
	
	
	
	public double futureValue(int years) {
		double futureBalance = getBalance() * Math.pow(1 + getInterestRate(), years);
		return futureBalance;
	}


	
}//class











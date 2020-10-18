package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

public class BankAccount {
	public long accountNumber;
	public double balance, interestRate, futureBalance;
	
	BankAccount(){
	}
	
	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		
	}
	
	BankAccount(long accountNumber, double balance, double interestRate){
		this.accountNumber = new Random().nextLong();
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		
	}
	
	java.util.Date getOpenedOn() {
		return null;
	}
	
	static BankAccount readFromString(String accountData) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(""));
			//format.parse();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		}
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public boolean withdraw(double amount) {
		if(amount < balance && amount > 0) {
			this.balance -= amount;
			return true;
		}else {
			System.out.println("Not enough money!!!");
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return true;
		}else {
			System.out.println("Cannot deposit a negative amount");
			return false;
		}
	}
	
	public double futureValue(int years) {
		futureBalance = (balance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}
}

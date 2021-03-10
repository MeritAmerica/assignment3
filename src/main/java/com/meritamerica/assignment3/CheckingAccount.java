package com.meritamerica.assignment3;

import java.text.DecimalFormat;

public class CheckingAccount {

	private	double balance;
	private double ckInt = 0.000;
	
	public CheckingAccount(double openingBalance) {
		this.balance = openingBalance;
	}
	
	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return ckInt;
	}
	
	/* 
	 * Checks withdrawal amount: 
	 * If the requested amount is greater than the balance,
	 * no calculation is performed and returns false. 
	 */
	public boolean withdraw(double amount) {

		if(amount < balance) {
			this.balance -= amount;
			return true;
		} 
		return false;
	}

	/* 
	 * Checks deposit amount: 
	 * If the deposit amount is a negative number,
	 * no calculation is performed and returns false. 
	 */
	public boolean deposit(double amount) {

		if(amount > 0) {
			this.balance += amount;
			return true;
		} 
		return false;
	}
	/*
	 * Calculation: Future Value based on current balance and interest.
	 */
	public double futureValue(int years) {
		double fv = getBalance() * Math.pow(1 + ckInt, years);
		return fv;
	}
	
	/*
	 * DecimalFormat() 
	 * Converts and formats double/floating/exponential notation to decimal format.
	 * toString(): Concatenates requested data for final println in main().
	 */
	public String toString() {

		DecimalFormat dfInt = new DecimalFormat("0.#####");
		DecimalFormat dfFutVal = new DecimalFormat("0.00");

		String concat1 = "Checking Account Balance: " + "$"+ getBalance() + "\n";
		String concat2 = "Checking Account Interest Rate: " + dfInt.format(getInterestRate()) + "\n"; 
		String concat3 = "Checking Account Balance in 3 years: " + dfFutVal.format(futureValue(3)) + "\n";
		String concatChk = concat1 + concat2 + concat3;

		return concatChk;
	}
}

// End CheckingAccount.java










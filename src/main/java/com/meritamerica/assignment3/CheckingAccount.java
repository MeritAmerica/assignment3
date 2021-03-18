package com.meritamerica.assignment3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount{
	
	private double interestRate = 0.0001;
	
	//Sets opening balance
	public CheckingAccount(double openingBalance){
		super.balance = openingBalance;
	}
	
	CheckingAccount(long accNum, double balance, double interestRate, Date openDate){
		super.balance = balance;
		this.interestRate = interestRate;
		super.openDate = openDate;
		super.accountNumber = accNum;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public static CheckingAccount readFromString(String accountData) throws ParseException{
		int firstChkAcct = 0;
		int lastChkAcct = accountData.indexOf(",");
		long accNum = Integer.parseInt(accountData.substring(firstChkAcct, lastChkAcct));
		
		try {
//			int firstCh = 0;
//			int lastCh = accountData.indexOf(",");
//			long accNum = Integer.parseInt(accountData.substring(firstChkAcct, lastChkAcct));
			
			firstChkAcct = lastChkAcct + 1;
			lastChkAcct = accountData.indexOf(",", firstChkAcct);
			double balance = Double.parseDouble(accountData.substring(firstChkAcct, lastChkAcct));
			
			firstChkAcct = lastChkAcct + 1;
			lastChkAcct = accountData.indexOf(",", firstChkAcct);
			double iRate = Double.parseDouble(accountData.substring(firstChkAcct, lastChkAcct));
			
			firstChkAcct = lastChkAcct + 1;
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date openDate = df.parse(accountData.substring(firstChkAcct));
			
			CheckingAccount checkingAccount = new CheckingAccount(accNum, balance, iRate, openDate);
			
			return checkingAccount;
		}
		catch(Exception e){
				throw new NumberFormatException();
		}
	}

	
	// Outputs account info
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String checkAccInfo = getAccountNumber() + "," + getBalance() + "," + String.format("%.4f", getInterestRate()) + "," + df.format(getOpenedOn());
		return checkAccInfo;
	}
	
	
}

















package com.meritamerica.assignment3;

public class CDAccount {
	
	private CDOffering myOffering = null; 
	private double endingBalance;
	
	//CDAccount is a constructor. It creates the object.
	public CDAccount(CDOffering offering, double balance) {
	   this.myOffering = offering;
	   this.endingBalance = balance;
	}

	public  double getBalance() {
		return endingBalance;
	}
	
	public double getInterestRate() {
		return myOffering.getInterestRate();
		
	}
	
	public int getTerm() {
		return myOffering.getTerm();
	}
	
	public long getAccountNumber() {
		return getAccountNumber();
	}
	
	public double futureValue() {
		return futureValue();
	}

	public String toString() {
		String myCDOff = ""; 
		return myCDOff + this.myOffering;
	}
}










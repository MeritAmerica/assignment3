package com.meritamerica.assignment3;

public class CDOffering {

	private int loanTerm;
	private double intRate;

	public CDOffering(int term, double interestRate) {
		this.loanTerm = term;
		this.intRate = interestRate;

	}

	public int getTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getInterestRate() {
		return intRate;
	}

	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}
	
	public String toString() {
		String myCDOff = ""; 
		return myCDOff + "Term: " + this.loanTerm + "\nRate: " + this.intRate;
	}
}

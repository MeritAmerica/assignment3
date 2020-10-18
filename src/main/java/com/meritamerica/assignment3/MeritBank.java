package com.meritamerica.assignment3;

public class MeritBank {
	public static int size = 5, numberOfAccountHolders = 0, numberOfCDOfferings = 0;
	public static long[] accountNumbers = new long[size];
	public static AccountHolder[] accountHolders = new AccountHolder[size];
	public static CDOffering[] CDOfferings = new CDOffering[size];
	
	/*
	MeritBank(){
		
	}*/
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		if(numberOfAccountHolders == size) {
			size *= 2;
			AccountHolder[] temp = new AccountHolder[size];
			for(int i = 0; i < numberOfAccountHolders; i++) {
				temp[i] = accountHolders[i];
			}
			accountHolders = temp;
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}else {
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}
	
	public static CDOffering[] getCDOfferings() {
		return CDOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				best = CDOfferings[i];
			}
		}
		return best;
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering secondBest = CDOfferings[0];
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				secondBest = best;
				best = CDOfferings[i];	
			}
		}
		return secondBest;
	}
	
	public static void clearCDOfferings() {
		CDOfferings = null;
	}
	
	public static void setCDOfferings(CDOffering[] offerings) { 
		CDOfferings = offerings;
	}
	
	public static long getNextAccountNumber() {
		return accountNumbers[numberOfAccountHolders];
	}
	
	
	// List account holders displayed in ascending order of their total balances (End of Assignment 3)
	// https://docs.google.com/document/d/13BmjQpgCn4dliDZCj_Qts7Qr6vv1NJyMwtssQ38jSQA/edit#
	public static double totalBalances() {
		double total = 0.0;
		for(int i = 0; i < numberOfAccountHolders; i++) {
			total += (accountHolders[i].getTotalAccountBalances());
		}
		return total;
	}
	
	public String toString() {
		return "AccountHolders: " + accountHolders + 
				"CDOfferings: " + CDOfferings;
	}
	
}
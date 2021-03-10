package com.meritamerica.assignment3;

/**
 * AccounHolder class parameterized constructor: 
 * 	1. contains all information pertaining to the account holder
 * 	2. sets & gets client information
 * 	3. initializes arrays for each type of account
 *	4. gets account balances 
 *	5. totals and returns current balances for all accounts per client
 *	6. totals and returns all holdings for all clients at MeritBank
 */

public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;

	private CheckingAccount[] chkAcctsArray;
	private SavingsAccount[] savAcctsArray;
	private CDAccount[] cdAcctsArray;

	AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		
		chkAcctsArray = new CheckingAccount[0];
		savAcctsArray = new SavingsAccount[0];
		cdAcctsArray = new CDAccount[0];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Object getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public int getNumberOfCheckingAccounts() {
		return this.chkAcctsArray.length;
	}

	public double getCheckingBalance() {
		double result = 0.0;
		for (CheckingAccount account : this.chkAcctsArray) {
			result += account.getBalance();
		}
		return result;
	}

	public int getNumberOfSavingsAccounts() {
		return this.savAcctsArray.length;
	}

	public double getSavingsBalance() {
		double result = 0.0;
		for (SavingsAccount account : this.savAcctsArray) {
			result += account.getBalance();
		}
		return result;
	}

	public int getNumberOfCDAccounts() {
		return this.cdAcctsArray.length;
	}

	public double getCDBalance() {
		double result = 0.0;
		for (CDAccount account : this.cdAcctsArray) {
			result += account.getBalance();
		}
		return result;
	}

	public double getCombinedBalance() {
		return getCheckingBalance() + getSavingsBalance() + this.getCDBalance();
	}

	CheckingAccount[] getCheckingAccounts() {
		return this.chkAcctsArray;
	}

	SavingsAccount[] getSavingsAccounts() {
		return this.savAcctsArray;
	}

	CDAccount[] getCDAccounts() {
		return this.cdAcctsArray;
	}

	// To String Method
	public String toString() {
		return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + " " + this.ssn;
	}

	/*
	 * addCheckingAccount() and addSavingsAccount() methods: 
	 * 1. First if() checks openingBalance is not greater than the $250,000 limit. 
	 * 2. Second if() checks openingBalance does not push balance above $250,000 limit. 
	 * 3. Loops through the newChkAcct[] array and adds a new account. 
	 * 4. Creates a new index for the next new account and the openingBalance amount. 5.
	 */
	CheckingAccount addCheckingAccount(double openingBalance) {
		if (openingBalance <= 250000) {
			if (getCheckingBalance() + getSavingsBalance() + openingBalance <= 250000) {
				CheckingAccount[] newChkAcct = new CheckingAccount[this.chkAcctsArray.length + 1];

				for (int i = 0; i < this.chkAcctsArray.length; i++) {
					newChkAcct[i] = this.chkAcctsArray[i];
				}
				
				newChkAcct[newChkAcct.length - 1] = new CheckingAccount(openingBalance);
				this.chkAcctsArray = newChkAcct;
				return this.chkAcctsArray[this.chkAcctsArray.length - 1];
			}
		}
		
		System.out.println("Unable to open Checking Account: Deposit exceeds $250,000.");
		return null;
	}

	CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {

		if (getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() <= 250000) {

			CheckingAccount[] newChkAcct = new CheckingAccount[this.chkAcctsArray.length + 1];

			for (int i = 0; i < this.chkAcctsArray.length; i++) {
				newChkAcct[i] = this.chkAcctsArray[i];
			}
			newChkAcct[newChkAcct.length - 1] = checkingAccount;
			this.chkAcctsArray = newChkAcct;
			return checkingAccount;
		}
		return null;
	}

	SavingsAccount addSavingsAccount(double openingBalance) {
		if (openingBalance <= 250000) {
			if (getCheckingBalance() + getSavingsBalance() + openingBalance < 250000) {
				
				SavingsAccount[] newSavAcct = new SavingsAccount[this.savAcctsArray.length + 1];

				for (int i = 0; i < this.savAcctsArray.length; i++) {
					newSavAcct[i] = this.savAcctsArray[i];
				}
				newSavAcct[newSavAcct.length - 1] = new SavingsAccount(openingBalance);
				this.savAcctsArray = newSavAcct;
				return this.savAcctsArray[this.savAcctsArray.length - 1];
			}
		}
		System.out.println("Unable to open Savings Account: Deposit exceeds $250,000.");
		return null;
	}

	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		if (getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance() < 250000) {
			
			SavingsAccount[] newSavAcct = new SavingsAccount[this.savAcctsArray.length + 1];

			for (int i = 0; i < this.savAcctsArray.length; i++) {
				newSavAcct[i] = this.savAcctsArray[i];
			}
			newSavAcct[newSavAcct.length - 1] = savingsAccount;
			this.savAcctsArray = newSavAcct;
			return this.savAcctsArray[this.savAcctsArray.length - 1];
		}
		return null;
	}
	/*
	 * addCDAccount() method: 
	 * 1. Check to make sure there are actually some CD offerings. 
	 * 2. Return null if there are no CD offerings. 
	 */

	CDAccount addCDAccount(CDOffering cdOffering, double openingBalance) {
		if (cdOffering == null) {
			return null;
		}
		return addCDAccount(new CDAccount(cdOffering, openingBalance));
	}

	/* 
	 * addCDAccount () method: 
	 * 1. Loops through the newCDAcct[] array and adds a new account. 
	 * 2. Creates a new index for the each new CD account.
	 */
	CDAccount addCDAccount(CDAccount cdAccount) {
		if (cdAccount == null) {
			return null;
		}
		CDAccount[] newCDAcct = new CDAccount[this.cdAcctsArray.length + 1];

			for (int i = 0; i < this.cdAcctsArray.length; i++) {
				newCDAcct[i] = this.cdAcctsArray[i];
			}
			newCDAcct[newCDAcct.length - 1] = cdAccount;
			this.cdAcctsArray = newCDAcct;
			return this.cdAcctsArray[this.cdAcctsArray.length - 1];
	}
}





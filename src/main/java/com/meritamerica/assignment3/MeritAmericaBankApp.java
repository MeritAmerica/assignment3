package com.meritamerica.assignment3;

public class MeritAmericaBankApp {

	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		

	
	/* Save data to file, and to be able to read the data from the file
	* 1.) Merit Bank - List of Account Holders, List of CD Offerings, Next acc number
	* 2.) CD Offering - Description, Term, Interest Rate
	* 3.) A.H. - Account Holder details, Current Balance, Interest Rate, Date acc opened
	* 4.) Checking Acc - Acc number, Current Balance, Interest Rate, Date acc opened
	* 5.) Savings Acc - Acc number, Current Balance, Interest Rate, Date acc opened
	* 6.) CD Acc - Acc number, Openeing Balance, Term, Interest rate, Date acc opened
	* 
	*Note: when reading from file, the data should overwrite the MeritBank data such that previous 
	*  data no longer exists, only the data read from the file should exist.

	Note: we will not be using Java Serialization since Merit America Bank wants other 
	(possibly non-Java) applications to be able to parse this file.

	Finally, after reading the file, Merit America Bank would like the list of account holders 
	displayed in ascending order of their total balances.
	*/
	
	
	/* Expectations
	 *  1) Functionality from prior assignments should still work except where amended for this assignment’s requirements
	 *  2) Write your own unit tests for all of the requirements in this assignment (think about edge cases)
	 *  3) Code should be readable. For example: use meaningful variable names, use proper naming conventions, properly indent code, comment your code
	 *  4) Use the “this” keyword to reference instance variables/methods
	 *  5.) Utilize exception handling (try/catch/throws) to properly handle errors


	 */
}
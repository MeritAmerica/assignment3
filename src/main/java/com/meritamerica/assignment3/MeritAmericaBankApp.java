package com.meritamerica.assignment3;

//import java.io.*;

public class MeritAmericaBankApp {

	public static void main(String[] args) {

		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
//		MeritBank.readFromFile("src/test/testMeritBank_bad.txt");
//		MeritBank.readFromFile("testMeritBank_good.txt");
		
		CDOffering[] CDOfferings = new CDOffering[5];
		CDOfferings[0] = new CDOffering(1, 1.8 / 100);
		CDOfferings[1] = new CDOffering(2, 1.9 / 100);
		CDOfferings[2] = new CDOffering(3, 2.0 / 100);
		CDOfferings[3] = new CDOffering(5, 2.5 / 100);
		CDOfferings[4] = new CDOffering(10, 2.2 / 100);
		MeritBank.setCDOfferings(CDOfferings);

		/* 4.a.ii Instantiate a new AccountHolder (ah1) */
		String ah1FirstName = "Augusta";
		String ah1MiddleName = "Ada";
		String ah1LastName = "Byron";
		String ah1SSN = "181-50-1852";
		String ah1NameConcat = ah1FirstName + " " + ah1MiddleName + " " + ah1LastName;

		
		System.out.println();
		System.out.println();

		AccountHolder ah1 = new AccountHolder(ah1FirstName, ah1MiddleName, ah1LastName, ah1SSN);
		System.out.println("*************************\n" 
							+ ah1NameConcat + "\n" 
							+ ah1SSN 
							+ "\n*************************\n");

		/*
		 * 4.a.iii Add a checking account with an opening balance of $1,000 as well as a
		 * savings account with an opening balance of $10,000 to ah1
		 */
		System.out.println(">> [4.a.iii] Add a Checking Account: $1,000 and Savings Account: $10,000 <<");
		System.out.println(ah1.addCheckingAccount(1000));
		System.out.println(ah1.addSavingsAccount(10000));
		System.out.println("----------------------------------------------------------------");
		System.out.println(">> Current balance for " + ah1NameConcat + " is: " + ah1.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");

		/*
		 * 4.a.iv Add a checking account with an opening balance of $5,000 as well as a
		 * savings account with an opening balance of $50,000 to ah1
		 */
		System.out.println(">> [4.a.iv] Add a Checking Account: $5,000 and Savings Account: $50,000 <<");
		System.out.println(ah1.addCheckingAccount(5000));
		System.out.println(ah1.addSavingsAccount(50000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Current balance for " + ah1NameConcat + " is: " + ah1.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");

		/*
		 * 4.a.v Add a checking account with an opening balance of $50,000 as well as a
		 * savings account with an opening balance of $500,000 to ah1
		 */
		System.out.println(">> [4.a.v] Add a Checking Account: $50,000 and Savings Account: $500,000 <<");
		System.out.println(ah1.addCheckingAccount(50000));
		System.out.println(ah1.addSavingsAccount(500000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Current balance for " + ah1NameConcat + " is: " + ah1.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");

		/*
		 * 4.a.vi Add a checking account with an opening balance of $5,000 as well as a
		 * savings account with an opening balance of $50,000 to ah1
		 */
		System.out.println("\n>> [4.a.vi] Add a Checking Account: $5,000 and Savings Account: $50,000 <<");
		System.out.println(ah1.addCheckingAccount(5000));
		System.out.println(ah1.addSavingsAccount(50000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Current balance for " + ah1NameConcat + " is: " + ah1.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");

		/*
		 * 4.a.vii Add the best CD offering as a CD account on ah1
		 */
		System.out.println("\n>> [4.a.vii] Add the best CD offering to " + ah1NameConcat + " <<");
		System.out.println(ah1.addCDAccount(MeritBank.getBestCDOffering(1000), 1000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Combined balance for " + ah1NameConcat + " is: " + ah1.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");

		/* 4.a.viii Add ah1 to Merit Bank's list of account holders */
		MeritBank.addAccountHolder(ah1);

		// **********************************************************************************************************		
		
		/* 4.a.x Instantiate a new AccountHolder (ah2) */
		String ah2FirstName = "Grace";
		String ah2MiddleName = "Murray";
		String ah2LastName = "Hopper";
		String ah2SSN = "190-60-1992";
		String ah2NameConcat = ah2FirstName + " " + ah2MiddleName + " " + ah2LastName;

		AccountHolder ah2 = new AccountHolder(ah2FirstName, ah2MiddleName, ah2LastName, ah2SSN);
		System.out.println("*************************\n" 
				+ ah2NameConcat + "\n" 
				+ ah2SSN 
				+ "\n*************************\n");

		/* 4.a.xi Add a checking account with an opening balance of $1,000 as well as a
		 * savings account with an opening balance of $10,000 to ah2
		 */
		System.out.println(">> [4.a.xi] Add a Checking Account: $1,000 and Savings Account: $10,000 <<");
		System.out.println(ah2.addCheckingAccount(1000));
		System.out.println(ah2.addSavingsAccount(10000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Combined balance for " + ah2NameConcat + " is: " + ah2.getCombinedBalance());
		System.out.println("----------------------------------------------------------------");

		/*
		 * 4.a.xii Add the second best CD offering as a CD account on ah2
		 */
		System.out.println("\n>> [4.a.xii] Add the second best CD offering to " + ah2NameConcat + " <<");
		System.out.println(ah2.addCDAccount(MeritBank.getSecondBestCDOffering(1000), 1000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Combined balance for " + ah2NameConcat + " is: " + ah2.getCombinedBalance());
		System.out.println("----------------------------------------------------------------\n");


		/* 4.a.xiii Add ah2 to Merit Bank's list of account holders */
		MeritBank.addAccountHolder(ah2);

        /* 4.a.xiv Clear the CDs being offered by MeritBank */
        MeritBank.clearCDOfferings();

        // **********************************************************************************************************		
     	
        /* 4.a.x Instantiate a new AccountHolder (ah2) */
 		String ah3FirstName = "Anita";
 		String ah3MiddleName = "Borg";
 		String ah3LastName = "Naffz";
 		String ah3SSN = "194-90-2003";
 		String ah3NameConcat = ah3FirstName + " " + ah3MiddleName + " " + ah3LastName;

 		AccountHolder ah3 = new AccountHolder(ah3FirstName, ah3MiddleName, ah3LastName, ah3SSN);
		System.out.println("*************************\n" 
				+ ah3NameConcat + "\n" 
				+ ah3SSN 
				+ "\n*************************\n");

		/*
		 * 4.a.xvi Add the second best CD offering as a CD account on ah3
		 */
		System.out.println(">> [4.a.xvi] Add the second best CD offering to " + ah3NameConcat + " <<");
		System.out.println(ah3.addCDAccount(MeritBank.getSecondBestCDOffering(1000), 1000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Combined balance for " + ah3NameConcat + " is: " + ah3.getCombinedBalance());
		System.out.println("----------------------------------------------------------------");

		/*
		 * 4.a.viii Add a checking account with an opening balance of $1,000 as well as a
		 * savings account with an opening balance of $10,000 to ah3
		 */
		System.out.println(">> [4.a.viii] Add a Checking Account: $1,000 and Savings Account: $10,000 <<");
		System.out.println(ah3.addCheckingAccount(1000));
		System.out.println(ah3.addSavingsAccount(10000));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Combined balance for " + ah3NameConcat + " is: " + ah3.getCombinedBalance());
		System.out.println("----------------------------------------------------------------");


		/* 4.a.xix Add ah3 to Merit Bank's list of account holders */
		MeritBank.addAccountHolder(ah3);

		System.out.println("\n==============================================================================================");		
    	
		/* 4.a.xx Get the total balance of all accounts held by Merit Bank's account holders */
		double bankTotalBalance = MeritBank.totalBalances();
		System.out.println(
				">> [4.a.xx] Total balance of all accounts held by Merit Bank's account holders is: " + bankTotalBalance);
		System.out.println("==============================================================================================");		

	}
}

//package com.meritamerica.assignment3;
//
//public class MeritAmericaBankApp {
//	public static void main(String[] args) {
//		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
//	}
//
//	
//}
package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MeritBank {

    private static AccountHolder[] accountHolders = new AccountHolder[0];
    private static CDOffering[] cdOfferings = new CDOffering[5];
    private static long accountNumber = 100000;
	static int best = 0;
	static int second = 0; 

//<------------------------------------------------------------------->
	
	/* Stanford Lecture 15 */
	 public static void readFromFile(String file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader rd = new BufferedReader(reader);
            String line;
 
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
//<------------------------------------------------------------------->

	static void addAccountHolder(AccountHolder accountHolder) {
        AccountHolder[] newAcctHold = new AccountHolder[MeritBank.accountHolders.length + 1];

        for (int i = 0; i < MeritBank.accountHolders.length; i++)
            newAcctHold[i] = MeritBank.accountHolders[i];

        newAcctHold[newAcctHold.length - 1] = accountHolder;
        MeritBank.accountHolders = newAcctHold;
    }

    public static AccountHolder[] getAccountHolders() {
        if (accountHolders.length == 0)
            return null;
        return MeritBank.accountHolders;
    }

    public static CDOffering[] getCDOfferings() {

        if (cdOfferings.length == 0) {
            return null;
        }
        return MeritBank.cdOfferings;
    }

	public static CDOffering getBestCDOffering(double depositAmount) {
		
		double futVal1 = 0;
		double futVal2 = 0;
		double futVal3 = 0;
		
		for(int i = 0; i < cdOfferings.length; i++) {
			
			if(cdOfferings[i] != null) {
				futVal1= futureValue(depositAmount, cdOfferings[i].getInterestRate(), cdOfferings[i].getTerm());
				if(i != (cdOfferings.length - 1)) {
					i++;
					futVal2= futureValue(depositAmount, cdOfferings[i].getInterestRate(), cdOfferings[i].getTerm());	
				}

				if(futVal1 > futVal2) {
					
					if(futVal1 > futVal3) {
						futVal3 = futVal1;
						best = i;
						second = i-1;
					}
				} else {
				
					if(futVal2 > futVal3) {
						futVal3 = futVal2;
						best = i;
						second = i - 1;
					}
				}	
			}
		}
			return cdOfferings[best];
	}

	/* Select and return second best CD offering */
    public static CDOffering getSecondBestCDOffering(double depositAmount) {
        if (cdOfferings.length == 0) {
        	System.out.println("Unable to purchase a CD: MeritBank is not offering CDs at this time.");
            return null;
        }
        double[] offeringValues = new double[cdOfferings.length];
        int[] index = new int[cdOfferings.length];
        
        double carryOfferVal;
        int carryIntRate;

        for (int i = 0; i < cdOfferings.length; i++) {
            offeringValues[i] = MeritBank.futureValue(depositAmount, cdOfferings[i].getInterestRate(),
                    cdOfferings[i].getTerm());
            index[i] = i;
        }

        for (int i = 0; i < cdOfferings.length; i++) {
            for (int j = i + 1; j < cdOfferings.length; j++) {

                if (offeringValues[i] > offeringValues[j]) {

                    carryOfferVal = offeringValues[i];
                    offeringValues[i] = offeringValues[j];
                    offeringValues[j] = carryOfferVal;

                    carryIntRate = index[i];
                    index[i] = index[j];
                    index[j] = carryIntRate;
                }
            }
        }
        return cdOfferings[index[index.length - 2]];
    } 


    public static void clearCDOfferings() {
        MeritBank.cdOfferings = new CDOffering[0];
    }


    /* 
     * clearCDOfferings() cleared the Array, setCDOfferings reinitializes the array 
     */
	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = new CDOffering[5];
		for (int i =0; i < offerings.length; i++) {
			cdOfferings[i] = offerings[i];
		}
	}

	public static long getNextAccountNumber() {
		return accountNumber++;
	}

	public static double totalBalances() {
		double total = 0.0;
		for (AccountHolder holder : accountHolders) {
			total += holder.getCombinedBalance();
		}
		return total;
		}

	public static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue * Math.pow(1 + interestRate, term);
	}

}









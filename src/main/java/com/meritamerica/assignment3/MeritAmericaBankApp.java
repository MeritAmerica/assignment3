package com.meritamerica.assignment3;

//package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
		System.out.println("package second.practice.assignment3");
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		MeritBank.writeToFile("src/test/testMeritBank_good.txt");

//		MeritBank.readFromFile("testMeritBank_good.txt");
//		MeritBank.writeToFile("testMeritBank_good.txt");

	}
}

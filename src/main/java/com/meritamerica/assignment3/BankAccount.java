package com.meritamerica.assignment3;

//Bank account is the parent to checking and savings account.
public class BankAccount {

    // Instance variables
    private long accountNumber;
    private double balance;
    private double interestRate;

    // Constructor
    BankAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountNumber = MeritBank.getNextAccountNumber();
    }

    BankAccount(long accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    /* =========== Getters =========== */
    long getAccountNumber() {
        return this.accountNumber;
    }

    double getBalance() {
        return this.balance;
    }

    double getInterestRate() {
        return this.interestRate;
    }

    /* =========== Deposit, Withdraw and Future Value =========== */
    boolean withdraw(double amount) {
        if (amount >= 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    boolean deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    double futureValue(int years) {
        double futureBalanace = this.balance * Math.pow((1 + this.interestRate), years);
        return futureBalanace;
    }

}
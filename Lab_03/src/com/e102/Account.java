package com.e102;

public class Account {
    private int accountId;
    private String clientName;
    private double balance;
    private static double annualInterestRate = 0.045;

    Account(String clientName, int accountId, double balance){
        this.accountId = accountId;
        this.clientName = clientName;
        this.balance = balance;
    }

    public static double monthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double monthlyInterestAmount(){
        return monthlyInterestRate()*balance;
    }

    //for withdraw function
    public void withdrawValue(double value){
        if (value>balance){
            System.out.println("Your entered balance is more than the balance. Enter a sufficient value to withdraw");
        } else {
            balance = balance - value;
        }
    }

    //for deposit function
    public void depositValue(double value){
        balance += value;
    }

    //print client details
    public void printAccountDetails(){
        System.out.println("Account ID:\t" + accountId );
        System.out.println("Client name:\t" + clientName );
        System.out.println("Account balance:\t" + balance );
        System.out.println("Monthly interest:\t" + monthlyInterestAmount() );
    }
}

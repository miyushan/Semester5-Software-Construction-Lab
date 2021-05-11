package com.e102;

import java.util.Scanner;
/**
 *
 * Author: 2018/E/102
 *
 */
/**
 * This programme is used to get details about the banking system.
 */

public class Bank {
    private static Branch[] branches;
    private static int totBranches = 0;
    private int maxBranches = 60;   //assume maximum 60 branches for a bank

    public Bank(){
        this.branches = new Branch[maxBranches];
    }


    //add a new branch with initializing its details
    public Branch addBranch(String id, String location){
        branches[totBranches] = new Branch(id, location);
        totBranches++;
        return branches[totBranches-1];
    }


    //calculate total accounts
    public int totalAccounts(){
        int tot = 0;
        for (int i=0; i<totBranches; i++ ){
            tot += branches[i].totAcc();
        }
        return tot;
    }



    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);

        Bank bank = new Bank();

        //create branches for the bank
        Branch b1 = bank.addBranch("564345","Negombo");
        Branch b2 = bank.addBranch("435342","Colombo");
        Branch b3 = bank.addBranch("546378","Kilinochchi");
        Branch b4 = bank.addBranch("967856","Murukkandi");

        System.out.println("Monthly interest rate:\t" + Account.monthlyInterestRate()*100 + "%");

        System.out.println();
        b1.printBranchDetails();


        System.out.println();
        //give the details about a new client as a constructor
        Account account1 = b1.addAccount("Rodrigo S.M.", 4566, -538);

        System.out.println();
        account1.printAccountDetails();     //print initial details of the account

        account1.depositValue(500);     //deposit money in the account
        account1.withdrawValue(1020.50);    //withdraw money from the account

        System.out.println();
        account1.printAccountDetails();     //print details after transactions

        System.out.println("\nTotal accounts in the bank:\t" + bank.totalAccounts());
        System.out.println("Total branches:\t" + totBranches);  //print number of branches

    }
}

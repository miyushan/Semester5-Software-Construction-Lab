package com.e102;

import java.util.Scanner;

/**
 *This method is used to store details about Branch
 */
public class Branch {
    private String branchId;
    private String location;
    private int totAccounts = 0;
    private Account[] accounts;
    private int maxAccounts = 60;       //assume maximum accounts in a branch as 60

    Branch(String id, String location){
        this.branchId = id;
        this.location = location;
        accounts = new Account[maxAccounts];
    }

    //print details about the branch
    public void printBranchDetails(){
        System.out.println("Branch ID:\t" + branchId );
        System.out.println("Location:\t" + location );
        System.out.println("Number of accounts in the branch:\t" + totAccounts );
    }

    //this methode is used to calculate the total bank accounts
    public int totAcc(){
        return totAccounts;
    }

    //this is used to add an account according to the given conditions
    public Account addAccount(String accName, int accId, double balance){
        Scanner obj = new Scanner(System.in);

        while (!(accId>99999 && accId<1000000)){
            System.out.println("Invalid Id. Enter the correct id again with 6 digits:");
            accId = obj.nextInt();
        }
        while (balance<0){
            System.out.println("Invalid balance. Enter the correct balance again with a positive amount:");
            balance = obj.nextDouble();
        }

        accounts[totAccounts] = new Account(accName, accId, balance);
        totAccounts++;
        return accounts[totAccounts-1];
    }
}

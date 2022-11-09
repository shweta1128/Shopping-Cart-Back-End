package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }


    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public int withdraw(int amountToWithDraw){


       // int serviceCharge = 2;
        int totalBalance = getBalance() - amountToWithDraw;
        if (totalBalance >= 2){
           super.withdraw(amountToWithDraw);
            if (totalBalance < 150){
             super.withdraw(2);
            }
        }


        return getBalance();
    }
}

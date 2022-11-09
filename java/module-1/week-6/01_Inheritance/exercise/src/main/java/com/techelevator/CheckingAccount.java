package com.techelevator;

public class CheckingAccount extends BankAccount{
    /*
    public CheckingAccount(){
        super();
    }
    */

    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber , int balance){
        super(accountHolderName, accountNumber, balance);
    }

    public int  withdraw(int amountToWithdraw){


       // int overDraftFee = 10;
        int totalBalance = getBalance() - amountToWithdraw;

        if (totalBalance > -100  ) {
           // totalBalance = totalBalance ;
            super.withdraw(amountToWithdraw);
            if (totalBalance < 0){
                super.withdraw(10);

            }
            return getBalance();



        } //else if (totalBalance >= 100){
          //  return getBalance() - overDraftFee;
       // }
        return getBalance();
    }

}

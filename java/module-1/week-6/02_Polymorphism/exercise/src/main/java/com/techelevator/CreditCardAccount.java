package com.techelevator;

public class CreditCardAccount implements Accountable  {
    private String accountHolder;
    private String accountNumber;
    private int debt;

    public String getAccountHolder(){
        return  accountHolder;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public int getDebt(){

        return debt;
    }
    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public int getBalance(){
        return -debt;
    }
    public int pay(int amountToPay){
      //  int totalAmount = 0;

        debt -= amountToPay ;
        return debt;
    }
    public int charge(int amountToCharge){
        debt += amountToCharge;
        return debt;
    }


}

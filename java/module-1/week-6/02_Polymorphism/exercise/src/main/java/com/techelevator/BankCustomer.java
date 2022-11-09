package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName(){
        return name;

    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
//    public List<Accountable> getAccounts(){
//        return accounts;
//    }
    public void setName(String name){
        this.name = name;

    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
//    public int getBalance(){
//    return getBalance();
//    }
    public Accountable[] getAccounts(){
        Accountable[] list = new Accountable[accounts.size()];
    for (int i =0; i < accounts.size(); i++){
         list[i] = accounts.get(i);

    }


//        return getAccounts().toArray(new Accountable[0]);
        return list;
    }
    public void addAccount(Accountable newAccount){

        accounts.add(newAccount) ;

    }
    public Boolean isVip(){
        int total = 0;
       // for (int i = 0; i< accounts.size(); i ++){
        //    total += accounts.get(i).getBalance();

       // }
        for (Accountable account: accounts){
            total += account.getBalance();
        }

        if (total >= 25000 ){
            return true;
        }
        return false;
    }

}
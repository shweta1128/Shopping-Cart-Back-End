package com.techelevator.model;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private BigDecimal tax = new BigDecimal("0.0");
    private List<CartItem> getALl = new ArrayList<>();

    public Cart( List<CartItem> getALl) {
        this.getALl = getALl;
    }

    public BigDecimal getTax() {
        return tax;

    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public void setGetALl(List<CartItem> getALl) {
        this.getALl = getALl;
    }

    public List<CartItem> getGetALl() {
        return getALl;
    }
    public BigDecimal subTotalOfItems(){

        BigDecimal total = new BigDecimal("0.0");
        for(CartItem cartItem: getALl){
            total = total.add(cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQuantity())));

        }
          return total;
    }
}



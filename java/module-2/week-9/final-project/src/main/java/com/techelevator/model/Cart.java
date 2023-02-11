package com.techelevator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private BigDecimal subTotal = new BigDecimal("0.00");
    private BigDecimal total = new BigDecimal("0.00");

    private BigDecimal tax = new BigDecimal("0.0");
    private List<CartItem> getALl = new ArrayList<>();

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return subTotal.add(tax).setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cart(List<CartItem> getALl) {
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



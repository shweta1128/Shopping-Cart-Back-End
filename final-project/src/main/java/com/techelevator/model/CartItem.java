package com.techelevator.model;

import java.math.BigDecimal;

public class CartItem {

    private int cartItemId;
    private int userId;
    private int productId;
    private int quantity;
   // private BigDecimal price;
    private Product product;
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCartItemId() { return cartItemId;}
    public int getUserId() {
        return userId;
    }
    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setCartItemId(int cartItemId){ this.cartItemId = cartItemId;}
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem(){

    }

    public CartItem(int cartItemId, int userId, int productId, int quantity) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;

    }

}

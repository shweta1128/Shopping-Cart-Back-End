package com.techelevator.model;

public class WishListItem {
    private int wishlist_id;
    private int product_id;

    public WishListItem(int wishlist_id, int product_id) {
        this.wishlist_id = wishlist_id;
        this.product_id = product_id;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}

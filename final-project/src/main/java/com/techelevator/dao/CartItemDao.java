package com.techelevator.dao;

import com.techelevator.model.CartItem;

import java.math.BigDecimal;
import java.util.List;

public interface CartItemDao {

    List<CartItem> getAllItemsInCart (int userId);

    CartItem addToCartItem(int user_id, int product_id, int quantity);

    CartItem removeFromCartItem(int user_id, int cartItemId);

    List<CartItem> clearCart(int user_id);


}

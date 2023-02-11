package com.techelevator.dao;


import com.techelevator.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartItemDao implements CartItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCartItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate ;
    }

    @Override
    public List<CartItem> getAllItemsInCart(int userId) {
        List<CartItem> allItemsInCart = new ArrayList<>();
        String sqlForCartItem = "SELECT cart_item_id, user_id, quantity, product_id " +
                                 "FROM cart_item c " +
                                  "WHERE user_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForCartItem, userId);
        while (results.next()){
            allItemsInCart.add(mapRowToCartItem(results));
        }
        return allItemsInCart;
    }

    @Override
    public CartItem addToCartItem(int user_id, int product_id, int quantity) {




        return null;
    }

    @Override
    public CartItem removeFromCartItem(int user_id, int cartItemId) {
        return null;
    }

    @Override
    public List<CartItem> clearCart(int user_id) {
        return null;
    }

    private CartItem mapRowToCartItem(SqlRowSet results) {

        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(results.getInt("cart_item_id"));
        cartItem.setUserId(results.getInt("user_id"));
        cartItem.setProductId(results.getInt("product_id"));
        cartItem.setQuantity(results.getInt("quantity"));
//        cartItem.setPrice(results.getBigDecimal("price"));
        return cartItem;
    }




}

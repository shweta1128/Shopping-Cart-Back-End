package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> productForSale() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name " +
                "FROM product ; " ;

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    }


    public Product mapRowToProduct(SqlRowSet result){
        Product product = new Product();
        product.setProductId(result.getInt("product_id"));
        product.setProductSku(result.getString("product_sku"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setPrice(result.getBigDecimal("price"));
        product.setImageName(result.getString("image_name"));
        return product;
    }

    @Override
    public List<Product> productBySearch(String productName, String productSku) {
        List<Product> searchByNameOrSku = new ArrayList<>();
        String sqlForNameOrSku = "SELECT product_id, product_sku, name, description, price, image_name " +
                "FROM product " +
                "WHERE name ILIKE ? AND product_sku ILIKE ? ;";
        /* I used ILIKE here inorder to make the match-case insensitive */
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForNameOrSku,
                "%" + productName + "%" , "%" + productSku + "%");
        while (results.next()){
            searchByNameOrSku.add(mapRowToProduct(results));
        }
        return searchByNameOrSku;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        String sqlForProductId = "SELECT product_id, product_sku, name, description, price, image_name " +
                              "FROM product " + "WHERE product_id = ? ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForProductId, productId);
        if(results.next()){
            product = mapRowToProduct(results);
        }
        return product;
    }

    @Override
    public List<Product> listOfProductId(int user_id) {
        List<Product> products= new ArrayList<>();
        String sql = "SELECT product_id, product_sku, name, description, price, image_name"  +
                "FROM product WHERE product_id IN (SELECT product_id FROM cart_item WHERE user_id = ? ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;

    }

}

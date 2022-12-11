package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Product getProduct(int productId) {
        Product product = null;
        String sql =  "SELECT product_id, name, description,price,image_name " +
                "FROM product " +
                "WHERE product_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, productId);
        while(result.next()){
           product = mapRowToProduct(result);
        }
        return product;
    }

    private Product mapRowToProduct(SqlRowSet result) {
        Product product = new Product();
        product.setProductId(result.getInt("product_id"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setPrice(result.getBigDecimal("price"));
        product.setImageName(result.getString("image_name"));

        return product;

    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, name, description,price,image_name " +
                "FROM Product";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            products.add(mapRowToProduct(results));

        }
        return products;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> productWithNoSales = new ArrayList<>();
        String sql = "SELECT product_id, name, description,price,image_name " +
                "FROM product " +
                "WHERE product_id NOT IN (SELECT product_id FROM line_item); ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            productWithNoSales.add(mapRowToProduct(results));
        }
        return productWithNoSales;
    }

    @Override
    public Product createProduct(Product newProduct) {

        String sql = "INSERT INTO product " +
                "(name,description,price,image_name) " +
                "VALUES " +
                "( ?, ?, ?, ?)" +
                "RETURNING product_id";
      int id = jdbcTemplate.queryForObject(sql,int.class,newProduct.getName(),newProduct.getDescription(),newProduct.getPrice(),newProduct.getImageName());
         newProduct.setProductId(id);
        return newProduct;
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        String updateProductSql = "UPDATE product SET name = ?, description = ? , price = ? , image_name = ?  " +
                "WHERE product_id = ? ;";
         jdbcTemplate.update(updateProductSql, updatedProduct.getName(), updatedProduct.getDescription(),
                updatedProduct.getPrice(), updatedProduct.getImageName(), updatedProduct.getProductId());
    }

    @Override
    public void deleteProduct(int productId) {
       String deleteProductSql = "DELETE FROM product " + " WHERE product_id = ? ;";
        jdbcTemplate.update(deleteProductSql, productId);
    }
}

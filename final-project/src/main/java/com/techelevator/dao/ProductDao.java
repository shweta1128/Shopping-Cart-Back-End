package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {


/* Requirement 1- find a list of products for sale*/
    List<Product> productForSale();

/* Requirement 2- find a list of products by name or SKU.*/
    List<Product> productBySearch(String productName, String productSku);

/* Requirement 3- additional information about a specific product (product detail).*/
    Product getProductById(int productId);

    List<Product >  listOfProductId(int user_id);
}


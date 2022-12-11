package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import javax.sql.DataSource;
import java.beans.BeanProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class JdbcProductDaoTest extends BaseDaoTests {

 public static final Product PRODUCT_1 = new Product(1, "Product 1", "Description 1", new BigDecimal("9.99"), "product-1.png");
 public static final Product PRODUCT_2 = new Product(2, "Product 2", "Description 2", new BigDecimal("19.00"), "product-2.png");
 public static final Product PRODUCT_3 = new Product(3, "Product 3", "Description 3", new BigDecimal("123.45"), "product-3.png");
 public static final Product PRODUCT_4 = new Product(4, "Product 4", "Description 4", new BigDecimal("0.99"), "product-4.png");


 private JdbcProductDao productDao;
 private Product testProduct = new Product(1,"Product_name", "Description ", new BigDecimal("2.00"),"Image_name") ;

 @Before
 public void setup() {
  productDao = new JdbcProductDao(dataSource);
 }
 @Test
 public void getProduct_returns_correct_product_for_id(){
  //Act
  Product product =  productDao.getProduct(1);
  //Assert
  Assert.assertNotNull( "getProduct returns null", product);
  assertProductsMatch(PRODUCT_1, product);

  Product product4 =  productDao.getProduct(4);
  Assert.assertNotNull( "getProduct returns null", product4);
  assertProductsMatch(PRODUCT_4, product4);

 }

 @Test
 public void getProduct_returns_null_when_id_not_found() {
 Product product = productDao.getProduct(5);
  Assert.assertNull("getProduct failed to return null for id not in database", product);
 }

 @Test
 public void getProduct_returns_list_of_all_product() {
  List<Product> products = productDao.getProducts();
  Assert.assertEquals( 4, products.size());
  Assert.assertEquals(PRODUCT_1.getProductId(), products.get(0).getProductId());
  assertProductsMatch(PRODUCT_1, products.get(0));
  assertProductsMatch(PRODUCT_2, products.get(1));
  assertProductsMatch(PRODUCT_3, products.get(2));
  assertProductsMatch(PRODUCT_4, products.get(3));

 }

 @Test
 public void getProduct_returns_list_of_product_with_no_sales() {
  List<Product> productsWithNoSale = productDao.getProductsWithNoSales();

  assertProductsMatch(PRODUCT_3, productsWithNoSale.get(0));
 }

@Test
public void createProduct_returns_product_with_id_and_expected_values(){
  Product productCreated = productDao.createProduct(testProduct);
 Assert.assertNotNull("createProduct returned null", productCreated);

 int newId = productCreated.getProductId();
  Assert.assertTrue("productCreated failed to return a product with a id", newId > 0);
 testProduct.setProductId(newId);
 assertProductsMatch(testProduct, productCreated);

}

 @Test
 public void updated_product_has_expected_values_when_retrieved() {
  Product updateProduct = productDao.getProduct(2);
  updateProduct.setProductId(2);
  updateProduct.setName("Product 2");
  updateProduct.setDescription("Product 2");
  updateProduct.setPrice(new BigDecimal("19.00"));
  updateProduct.setImageName("Product 2");

  productDao.updateProduct(updateProduct);
 Product product1 = productDao.getProduct(2);

  assertProductsMatch(updateProduct,product1);

 }
 @Test
 public void deleted_product_cant_be_retrieved() {

  //Act - delete existing first timesheet
  productDao.deleteProduct(3);
  // Assert

 Product product =  productDao.getProduct(3);
  Assert.assertNull(product);


 }
 @Test
 public void product_with_sales_cant_be_deleted() {
  // An exception is expected if the customer has sales orders, and we try to delete the customer.
  try {
  productDao.deleteProduct(1);
  } catch (DataIntegrityViolationException exception) {
   // The DAO threw an exception because the row couldn't be deleted. Test passes. Return from the method.
   return;
  }
  // If control gets here, then the row was deleted. It shouldn't have been deleted, because
  // sales orders are attached to this customer. Therefore, FAIL the test.
  Assert.fail("A customer with sales orders should not be deleted.");
 }







 private void assertProductsMatch(Product expected, Product actual) {
  Assert.assertEquals(expected.getProductId(), actual.getProductId());
  Assert.assertEquals(expected.getName(), actual.getName());
  Assert.assertEquals(expected.getDescription(), actual.getDescription());
  Assert.assertEquals(expected.getPrice(), actual.getPrice());
  Assert.assertEquals(expected.getImageName(), actual.getImageName());

 }



}
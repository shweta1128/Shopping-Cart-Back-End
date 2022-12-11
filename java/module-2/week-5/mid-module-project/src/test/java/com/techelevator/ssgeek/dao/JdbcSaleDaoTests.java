package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests {

    private static final Sale SALE_1 = new Sale(1, 1, LocalDate.parse("2022-01-01"),  null);
    private static final Sale SALE_2 = new Sale(2, 1, LocalDate.parse("2022-02-01"),  LocalDate.parse("2022-02-02"));
    private static final Sale SALE_3 = new Sale(3, 2, LocalDate.parse("2022-03-01"),  null);
    private static final Sale SALE_4 = new Sale(4, 2, LocalDate.parse("2022-01-01"),  LocalDate.parse("2022-01-02"));

private JdbcSaleDao saleDao;
private Sale testSale  ;

   @Before
   public void setup(){
       saleDao = new JdbcSaleDao(dataSource);
       testSale = new Sale(1, 2, LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-02"));
   }

   @Test
    public void getSale_returns_correct_sale_for_id(){
       Sale sale = saleDao.getSale(1);
       //Assert.assertNotNull("get product returns null", sale);
     assertSalesMatch(SALE_1, sale );

   }
 @Test
 public void getSale_returns_null_when_id_not_found() {
    Sale sale = saleDao.getSale(5);
     Assert.assertNull("getCustomer failed to return null for id not in database", sale);
 }

    @Test
    public void getSale_returns_list_of_all_unshippedSales() {
        List<Sale> sales = saleDao.getSalesUnshipped();
        Assert.assertEquals(2, sales.size());
        Assert.assertEquals(SALE_1.getSaleId(), sales.get(0).getSaleId());
        assertSalesMatch(SALE_1, sales.get(0));
        assertSalesMatch(SALE_3, sales.get(1));

    }

    @Test
    public void getSale_by_customer_id_returns_list_of_all_customer_id() {
       List<Sale> testSale = saleDao.getSalesByCustomerId(2);
      Assert.assertEquals(2, testSale.size());
      assertSalesMatch(SALE_3,testSale.get(0));
    }

    @Test
    public void getSale_by_customer_id_returns_list_of_all_product_id() {
        List<Sale> testSaleProductId = saleDao.getSalesByProductId(1);
        Assert.assertEquals(3, testSaleProductId.size());
        Assert.assertEquals(SALE_1.getCustomerId(), testSaleProductId.get(0).getCustomerId());
        assertSalesMatch(SALE_1,testSaleProductId.get(0));
        assertSalesMatch(SALE_2,testSaleProductId.get(1));
        assertSalesMatch(SALE_3,testSaleProductId.get(2));


    }

    @Test
    public void createSales_returns_sales_with_id_and_expected_values() {
       Sale sale = saleDao.createSale(testSale);

        Assert.assertNotNull("createCustomer returned null", sale);

        int newId = sale.getSaleId();
        Assert.assertTrue("createCustomer failed to return a customer with an id", newId > 0);

      testSale.setSaleId(newId);
        assertSalesMatch( testSale, sale);


    }
    @Test
    public void created_sale_has_expected_values_when_retrieved() {
        Sale sale = saleDao.createSale(testSale);

        int newId = sale.getSaleId();
      Sale createdSale = saleDao.getSale(newId);

        assertSalesMatch( createdSale, sale);
    }


    @Test
    public void updated_sales_has_expected_values_when_retrieved() {
        Sale saleUpdated = saleDao.getSale(1);
      //  saleUpdated.setSaleId(1); can't change the sale ID as its the PK
        saleUpdated.setCustomerId(2);
        saleUpdated.setShipDate(LocalDate.parse("2022-01-01"));
        saleUpdated.setSaleDate(LocalDate.parse("2022-01-02"));

        saleDao.updateSale(saleUpdated);
        Sale sale1 =saleDao.getSale(1);
        assertSalesMatch( saleUpdated, sale1);
    }

    @Test
    public void deleted_sale_cant_be_retrieved(){

       saleDao.deleteSale(3);
       Sale deletedSale =  saleDao.getSale(3);
        Assert.assertNull(deletedSale);


    }
    private void assertSalesMatch(Sale expected, Sale actual){
       Assert.assertEquals(expected.getSaleId(), actual.getSaleId()) ;
       Assert.assertEquals(expected.getCustomerId(), actual.getCustomerId()) ;
      // Assert.assertEquals(expected.getCustomerName(), actual.getCustomerName()) ;
       Assert.assertEquals(expected.getSaleDate(), actual.getSaleDate()) ;
       Assert.assertEquals(expected.getShipDate(), actual.getShipDate()) ;

   }


}

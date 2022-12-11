package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcSaleDao(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSale(int saleId) {

        Sale sale = null;
        String sql = "SELECT s.sale_id, s.customer_id, c.name, s.sale_date, s.ship_date " +
                "FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "WHERE s.sale_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
        while(results.next()){
            sale = mapRowToSale(results);
        }
        return sale;
    }

    private Sale mapRowToSale(SqlRowSet results) {
        Sale sale = new Sale();
        sale.setSaleId(results.getInt("sale_id"));
        sale.setCustomerId(results.getInt("customer_id"));

            sale.setCustomerName(results.getString("name"));
            sale.setSaleDate(results.getDate("sale_date").toLocalDate());
        if(results.getDate("ship_date") != null) {
            sale.setShipDate(results.getDate("ship_date").toLocalDate());
        }
        return sale;
    }

    @Override
    public List<Sale> getSalesUnshipped() {
        List<Sale> unshippedSales = new ArrayList<>();
        String sql = "SELECT s.sale_id, s.customer_id, c.name, s.sale_date, s.ship_date " +
                "FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "WHERE ship_date IS NULL ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Sale sale = mapRowToSale(results);
            unshippedSales.add(sale);
        }

        return unshippedSales;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> salesByCustomerId = new ArrayList<>();
        String sql = "SELECT sale_id,c.customer_id, c.name, sale_date, ship_date " +
                      "FROM sale s" +
                     " JOIN customer c ON s.customer_id = c.customer_id " +
                      "WHERE c.customer_id = ? ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,customerId);
        while(results.next()){
            Sale sales = mapRowToSale(results);
            salesByCustomerId.add(sales);
        }
        return salesByCustomerId;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> salesByProductId = new ArrayList<>();
        String sql = "SELECT s.sale_id, c.customer_id, c.name,s.sale_date, s.ship_date " +
                     "FROM sale s " +
                     "JOIN customer c ON s.customer_id = c.customer_id " +
                     "JOIN line_item l ON s.sale_id = l.sale_id " +
                     "JOIN product p ON l.product_id = p.product_id " +
                     "WHERE p.product_id = ? ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
        while(results.next()){
            Sale sale = mapRowToSale(results);
            salesByProductId.add(sale);
        }
        return salesByProductId;
    }

    @Override
    public Sale createSale(Sale newSale) {

        String sql = "INSERT INTO sale ( customer_id, sale_date, ship_date) " +
                "VALUES (?, ? , ? ) "  +
                "RETURNING sale_id ;";
     int newId = jdbcTemplate.queryForObject(sql, int.class, newSale.getCustomerId() ,
                    newSale.getSaleDate(), newSale.getShipDate());
        return getSale(newId);
    }

    @Override
    public void updateSale(Sale updatedSale) {
        String sql = "UPDATE sale " +
                "SET customer_id = ?, sale_date = ? , ship_date = ? " +
                "WHERE sale_id = ? ;";
        jdbcTemplate.update(sql,updatedSale.getCustomerId(), updatedSale.getSaleDate(), updatedSale.getShipDate(),updatedSale.getSaleId());

    }

    @Override
    public void deleteSale(int saleId) {
        String sql = "DELETE FROM line_item " + "WHERE sale_id = ? ;";
        jdbcTemplate.update(sql,saleId);
       String sql1 = "DELETE FROM sale " + "WHERE sale_id = ? ;" ;
       jdbcTemplate.update(sql1,saleId);
    }
}

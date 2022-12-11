package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcLineItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public List<LineItem> getLineItemsBySale(int saleId) {

        List<LineItem> lineItems = new ArrayList<>();
        String sql ="SELECT l.line_item_id,l.sale_id,l.product_id,l.quantity " +
        "FROM line_item l " +
        "JOIN product p ON l.product_id = p.product_id " +
        "WHERE l.sale_id = ? " +
        "ORDER BY l.line_item_id ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
        while(results.next()){
        LineItem lineItem = mapRowToLineItem(results);
          lineItems.add(lineItem);
        }
        return lineItems;
    }

    private LineItem mapRowToLineItem(SqlRowSet results) {
      LineItem lineItem = new LineItem();
        lineItem.setLineItemId(results.getInt("line_item_id"));
       lineItem.setSaleId(results.getInt("sale_id"));
       lineItem.setProductId(results.getInt("product_id"));
        lineItem.setQuantity(results.getInt("quantity"));
        return lineItem;
    }

    }



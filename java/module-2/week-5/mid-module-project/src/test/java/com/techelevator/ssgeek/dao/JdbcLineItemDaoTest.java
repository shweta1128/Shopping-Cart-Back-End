package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDaoTest extends BaseDaoTests {

    private static final LineItem LINE_ITEM_1 = new LineItem(1, 1, 1,1, "Product_1", new BigDecimal("9.99"));
    private static final LineItem LINE_ITEM_2 = new LineItem(2, 1, 2,1, "Product_2", new BigDecimal("19.00"));
    private static final LineItem LINE_ITEM_3 = new LineItem(3, 1, 4,1, "Product_4", new BigDecimal("0.99"));
    private static final LineItem LINE_ITEM_4 = new LineItem(4, 2, 4,10, "Product_4", new BigDecimal("0.99"));
    private static final LineItem LINE_ITEM_5 = new LineItem(5, 2, 1,10, "Product_1", new BigDecimal("0.99"));
    private static final LineItem LINE_ITEM_6 = new LineItem(6, 3, 1,100, "Product_1", new BigDecimal("9.99"));



    private JdbcLineItemDao lineItemDao;
    private LineItem testLineItem  ;

    @Before
    public void setup(){
       lineItemDao = new JdbcLineItemDao(dataSource);
    }

    @Test
    public void getLineItem_returns_list_of_correct_sale_for_id(){
        List<LineItem> lineItems = lineItemDao.getLineItemsBySale(1);
        Assert.assertEquals(3, lineItems.size());
        Assert.assertEquals(LINE_ITEM_1.getSaleId(), lineItems.get(0).getSaleId());
        assertLineItemsMatch(LINE_ITEM_1, lineItems.get(0));
        assertLineItemsMatch(LINE_ITEM_2, lineItems.get(1));
        assertLineItemsMatch(LINE_ITEM_3, lineItems.get(2));
//      assertLineItemsMatch(LINE_ITEM_4, lineItems.get(3));
//      assertLineItemsMatch(LINE_ITEM_5, lineItems.get(4));
//      assertLineItemsMatch(LINE_ITEM_6, lineItems.get(5));


    }
    private void assertLineItemsMatch(LineItem expected, LineItem actual){
        Assert.assertEquals(expected.getLineItemId(), actual.getLineItemId()) ;
        Assert.assertEquals(expected.getSaleId(), actual.getSaleId()) ;
        Assert.assertEquals(expected.getProductId(), actual.getProductId()) ;
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity()) ;

    }
}

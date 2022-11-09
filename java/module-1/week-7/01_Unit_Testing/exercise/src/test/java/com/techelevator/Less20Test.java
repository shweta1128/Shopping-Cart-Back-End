package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void method_returns_true_if_less_than_20(){
        //Arrange
        Less20 multipleLessThan20 = new Less20();
        //Arrange
        Boolean actualResult = multipleLessThan20.isLessThanMultipleOf20(18);
        //Assert
        Assert.assertEquals(true, actualResult);

    }
    @Test
    public void method_returns_false_if_greater_than_20(){
        //Arrange
        Less20 multipleLessThan20 = new Less20();
        //Arrange
        Boolean actualResult1 = multipleLessThan20.isLessThanMultipleOf20(21);
        //Assert
        Assert.assertEquals(false, actualResult1);

    }
}

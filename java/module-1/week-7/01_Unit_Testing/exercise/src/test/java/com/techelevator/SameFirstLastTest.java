package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test
    public void method_return_true_if_array_is_length_1(){
        SameFirstLast firstLastMethod = new SameFirstLast();
        String actualResult = String.valueOf(firstLastMethod.isItTheSame(new int[]{1}));
        Assert.assertEquals("true", actualResult);
    }
    @Test
    public void method_return_true_if_array_is_length_more_than_1(){
        SameFirstLast firstLastMethod = new SameFirstLast();
     String actualResult = String.valueOf(firstLastMethod.isItTheSame(new int[]{1,2,3,1}));
        Assert.assertEquals("true", actualResult);
    }
    @Test
    public void method_returns_false_if_array_is_length_more_than_1_and_not_equal(){
        SameFirstLast firstLastMethod = new SameFirstLast();
       String  actualResult = String.valueOf(firstLastMethod.isItTheSame(new int[]{1,2,3,4}));
        Assert.assertEquals("false", actualResult);
    }

}

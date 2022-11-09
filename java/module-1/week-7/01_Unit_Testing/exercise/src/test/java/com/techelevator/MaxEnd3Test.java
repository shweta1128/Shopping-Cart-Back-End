package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {
    @Test
    public void method_that_max_value(){
        MaxEnd3 maxValue = new MaxEnd3();
        int[] array = new int[]{2,5,3};
        int[] array1 = new int[]{3,3,3};
        int[] actualResult = maxValue.makeArray(array);
        Assert.assertArrayEquals(array1,actualResult);
    }
    @Test
    public void method_that_max_value_for_1st(){
        MaxEnd3 maxValue = new MaxEnd3();
        int[] array = new int[]{11,13,5};
        int[] array1 = new int[]{11,11,11};
        int[] actualResult = maxValue.makeArray(array);
        Assert.assertArrayEquals(array1,actualResult);
    }
}

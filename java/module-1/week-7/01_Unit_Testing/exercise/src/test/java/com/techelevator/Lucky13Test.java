package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void method_returns_false_for_value_1_3() {
        Lucky13 luckyNos = new Lucky13();
        int[] array = new int[]{1, 2, 3};
        Boolean actualResult = luckyNos.getLucky(array);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void method_returns_true_for_value_not_equals_1_3() {
        Lucky13 luckyNos = new Lucky13();
        int[] array = new int[]{0, 2, 4};
        Boolean actualResult1 = luckyNos.getLucky(array);
        Assert.assertEquals(true, actualResult1);


    }
}

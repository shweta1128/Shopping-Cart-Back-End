package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void method_returns_every_other_char(){
        StringBits chars = new StringBits();
        String actualResult = chars.getBits("Hello");
        String actualResult1 = chars.getBits("Hi");
        String actualResult2 = chars.getBits("Heelllooo");
        Assert.assertEquals("Hlo", actualResult);
        Assert.assertEquals("H", actualResult1);
        Assert.assertEquals("Heloo",actualResult2);
        }

    }


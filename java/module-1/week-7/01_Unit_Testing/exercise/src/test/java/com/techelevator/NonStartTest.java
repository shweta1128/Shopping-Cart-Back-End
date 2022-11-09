package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test
    public void method_returns_all_chars_except_1st_chars_of_string(){
        NonStart stringChars = new NonStart();
        String actualResult = stringChars.getPartialString("Tiger", "Lion");
        Assert.assertEquals("igerion",actualResult );
    }
    @Test
    public void method_returns_at_least_1_string_length(){
        NonStart stringChars = new NonStart();
        String actualResult1 = stringChars.getPartialString("hi", "bye");
        Assert.assertEquals("iye",actualResult1);
    }
    @Test
    public void method_returns_empty_string(){
        NonStart stringChars = new NonStart();
        String actualResult1 = stringChars.getPartialString(null, null);
        Assert.assertEquals("",actualResult1);
    }
    @Test
    public void method_returns_empty_1_string(){
        NonStart stringChars = new NonStart();
        String actualResult1 = stringChars.getPartialString(null, "Toy");
        Assert.assertEquals("oy",actualResult1);
    }
    @Test
    public void method_returns_empty_2_string(){
        NonStart stringChars = new NonStart();
        String actualResult1 = stringChars.getPartialString("T", "A");
        Assert.assertEquals("",actualResult1);
    }
}

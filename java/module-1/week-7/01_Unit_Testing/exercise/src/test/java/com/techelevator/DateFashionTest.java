package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class DateFashionTest {
    @Test
    public void method_to_return_2(){
        //Arrange
        DateFashion fashion = new DateFashion();
        //Act
       long actualResult  = fashion.getATable(5, 10);
       long actualResult1 = fashion.getATable(5, 8);
        //Assert
        Assert.assertEquals(2,actualResult);
        Assert.assertEquals(2,actualResult1);
    }
    @Test
    public void method_to_return_0(){
        //Arrange
        DateFashion fashion = new DateFashion();
        //Act
        long actualResult2  = fashion.getATable(5, 2);
        long actualResult3 = fashion.getATable(5, 0);
        //Assert
        Assert.assertEquals(0,actualResult2);
        Assert.assertEquals(0,actualResult3);
    }
    @Test
    public void method_to_return_1(){
        //Arrange
        DateFashion fashion = new DateFashion();
        //Act
        long actualResult  = fashion.getATable(5, 5);
        long actualResult1 = fashion.getATable(5, 3);
        //Assert
        Assert.assertEquals(1,actualResult);
        Assert.assertEquals(1,actualResult1);
    }
}

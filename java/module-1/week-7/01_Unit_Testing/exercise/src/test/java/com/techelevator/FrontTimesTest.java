package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test
    public void method_to_create_strings_for_3_chars() {
        //Arrange
        FrontTimes front = new FrontTimes();
        //Act
        String actualResult = front.generateString("Chocolate", 3);
        //Assert
        Assert.assertEquals("ChoChoCho", actualResult);
    }

    public void method_to_create_strings_for_2_or_less_value_of_n() {
        //Arrange
        FrontTimes front = new FrontTimes();
        //Act
        String actualResult1 = front.generateString("Chocolate", 4);
        //Assert
        Assert.assertEquals("ChoChoChoCho", actualResult1);

    }
    public void method_to_create_strings_less_than_3_chars() {
        //Arrange
        FrontTimes front = new FrontTimes();
        //Act
        String actualResult1 = front.generateString("aa", -1);
        //Assert
        Assert.assertEquals("", actualResult1);

    }
}

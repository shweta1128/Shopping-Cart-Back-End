package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {


    @Test
    public void testing_animal_group_name_giraffe_returns_tower() {
        //Arrange
        AnimalGroupName animal = new AnimalGroupName();

        // Act

        String actualResult = animal.getHerd("giraffe");
        String actualResult1 = animal.getHerd("GiRaFfe");
       // String actualResult2 = animal.getHerd("");
       // String actualResult3 = animal.getHerd(null);

        //Assert
        Assert.assertEquals("Tower", actualResult);
        Assert.assertEquals("Tower", actualResult1);
       // Assert.assertEquals("unknown", actualResult2);
      //  Assert.assertEquals("unknown", actualResult3);

    }

    @Test
    public void testing_animal_group_name_blank_returns_unknown() {
        //Arrange
        AnimalGroupName animal = new AnimalGroupName();

        // Act


        String actualResult2 = animal.getHerd("");
        String actualResult3 = animal.getHerd(null);

        //Assert

        Assert.assertEquals("unknown", actualResult2);
        Assert.assertEquals("unknown", actualResult3);

    }
    @Test
    public void testing_for_edge_cases() {
        //Arrange
        AnimalGroupName animal = new AnimalGroupName();

        // Act

        String actualResult = animal.getHerd("walrus");
        String actualResult1 = animal.getHerd("unknown");
        String actualResult2 = animal.getHerd("WaLrus");
        String actualResult3 = animal.getHerd("unknown");

        //Assert
        Assert.assertEquals("unknown", actualResult );
        Assert.assertEquals("unknown", actualResult1);
        Assert.assertEquals("unknown", actualResult2);
        Assert.assertEquals("unknown", actualResult3);

    }
}
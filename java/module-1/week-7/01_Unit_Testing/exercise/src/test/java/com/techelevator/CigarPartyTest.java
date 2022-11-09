package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
    @Test
    public void method_returns_a_boolean_value_as_true(){
        // Arrange
        CigarParty cigarParty = new CigarParty();

        //Act
        Boolean actualResult = cigarParty.haveParty(40, true);
        Boolean actualResult1 = cigarParty.haveParty(60, true);

        //Assert
        Assert.assertEquals(true,actualResult);
        Assert.assertEquals(true, actualResult1);
    }

    @Test
    public void method_returns_a_boolean_value_as_false(){
        // Arrange
        CigarParty cigarParty = new CigarParty();

        //Act
        Boolean actualResult2 = cigarParty.haveParty(30, false);
        Boolean actualResult3 = cigarParty.haveParty(70, false);

        //Assert
        Assert.assertEquals(false,actualResult2);
        Assert.assertEquals(false, actualResult3);
    }
    @Test
    public void method_returns_a_boolean_value_as_true_for_edge_cases(){
        // Arrange
        CigarParty cigarParty = new CigarParty();

        //Act
        Boolean actualResult5 = cigarParty.haveParty(50, false);
        Boolean actualResult6 = cigarParty.haveParty(45, false);

        //Assert
        Assert.assertEquals(true,actualResult5);
        Assert.assertEquals(true, actualResult6);
    }
}

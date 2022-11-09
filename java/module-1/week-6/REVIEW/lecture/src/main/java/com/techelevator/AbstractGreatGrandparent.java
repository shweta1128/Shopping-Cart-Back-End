package com.techelevator;

public abstract class AbstractGreatGrandparent {
    private int age;


    abstract String getName();

    boolean isAgeOver100() {
        return age > 100;
    }

}

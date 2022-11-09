package com.techelevator;

public class Parent extends Grandparent {

    private String name;

    public Parent(String parentName) {
        this.name = parentName;
    }

    @Override
    public String getName() {
        return name;
    }

}

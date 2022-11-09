package com.techelevator;

public abstract class Wall {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public abstract int getArea();
       // int totalArea = 0;
//        int length = 0 ;
//        int width = 0;
//        return totalArea = length * width;
    //    return getArea();
    }
//    public abstract class wall {
//        // abstract void method
//     public int  getArea(){
//    }





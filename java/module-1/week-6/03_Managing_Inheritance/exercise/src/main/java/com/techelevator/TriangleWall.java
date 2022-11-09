package com.techelevator;

public  class TriangleWall extends Wall{
    private int base;

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    private int height;


    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        //super(height);
        this.base = base;
        this.height = height;

    }

    @Override
    public int getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return getName() + " " + "(" +
                  base +
                "x" + height +
                ')' + " " + "triangle";
    }
}

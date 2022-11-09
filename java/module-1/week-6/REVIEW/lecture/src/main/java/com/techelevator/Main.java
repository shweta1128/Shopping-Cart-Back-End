package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private String name;

    public Main(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Main myObject = new Main("My Name");
        String myString = "Hello World";

        // An object can be viewed as any of the classes or interfaces in its hierarchy.
        // All four of these objects are the same type (Child) because the same constructor is called four times.
        // These objects can be viewed four ways because the hierarchy has four levels.
        Child myChild1 = new Child("Child");
        Parent myChild2 = new Child("Parent");
        Grandparent myChild3 = new Child("Grandparent");
        Nameable myChild4 = new Child("Nameable");

        // The abstraction we view an object through can be changed to another class in its hierarchy.
        // We simply assign the object to a new variable name with a different data type.
        Grandparent childViewedAsGrandparent = myChild1;

        // Because all four objects have a common type, we can add all four to the same collection.
        // In other words a collection is "homogenous" in the way we view its elements.
        // Here we view all four elements as Nameable.
        List<Nameable> children = new ArrayList<>();
        children.add(myChild1);
        children.add(myChild2);
        children.add(myChild3);
        children.add(myChild4);

        // Can you guess what this will print out on line 3?
        for (Nameable child : children) {
            System.out.println(child.getName());
        }
    }

    /**
     * The Main class has a getName() method, but this method is unrelated to the {@link Nameable} interface or
     *  any of the classes in the {@link Child} hierarchy, because the Main class does not implement or extend those.
     */
    public String getName() {
        return name;
    }

}

package com.techelevator;

public class Child extends Parent {

    public Child(String childName) {
        super(childName);
    }

    public String getParentName() {
        return super.getName();
    }

    /**
     * Anywhere we see @Override is an example of polymorphism: a change to an inherited method.
     * The @Override syntax isn't strictly necessary, and even without it IntelliJ should display a
     *  blue circle with an "O" to indicate the method is overriding another.
     */
    @Override
    public String getName() {
        if ( super.getName().length() > 10 ) {
            return super.getName().substring(0, 10);
        }
        return super.getName();
    }

}

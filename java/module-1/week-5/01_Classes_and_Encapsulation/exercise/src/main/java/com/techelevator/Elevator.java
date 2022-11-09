package com.techelevator;

public class Elevator {
    private int currentFloor ;
    private int numberOfFloors;
    private boolean doorOpen;

    public int getCurrentFloor(){
        return currentFloor;
    }
    public int getNumberOfFloors(){
        return numberOfFloors;
    }
    public boolean isDoorOpen(){
        return doorOpen;
    }
    public Elevator(int numberOfFloors){
        currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
    }
    public void openDoor(){
        doorOpen = true;
    }
    public void closeDoor(){
        doorOpen = !doorOpen;
    }
    public void goUp(int desiredFloor){
        if (desiredFloor > currentFloor && desiredFloor <= numberOfFloors && ! doorOpen ){
             currentFloor = desiredFloor;
             //currentFloor++; this will increase the curentfloor, and the method asks for only the currentfloor to be the desired floor.


        }
    }
    public void goDown(int desiredFloor){
        if (desiredFloor < currentFloor && desiredFloor >= 1  && ! doorOpen) {
             currentFloor = desiredFloor;

        }

    }

}

package com.techelevator;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */

    private String name;
    private boolean open = false;
    private int numberOfCompactSlots;
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;

    private List<Car> compactList = new ArrayList<>();
    private List<Car> midSizeList = new ArrayList<>();
    private List<Car> fullSizeList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    public ParkingLot(String name) {
        this.name = name;
        this.open = false;
        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    // its just an error , so change getTotalSize to getLotSize
    public int getLotSize() {

        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int numberOfAvailableSlots(String carType) {
        if (carType.equals(Car.COMPACT)) {
            return numberOfCompactSlots - compactList.size();
        } else if (carType.equals(Car.MIDSIZE)) {
            return numberOfMidsizeSlots - midSizeList.size();
        } else if (carType.equals(Car.FULL_SIZE)) {
            return numberOfFullsizeSlots - fullSizeList.size();
        }

        return 0;
    }

    public boolean park(Car car) {
        if (car.getType().equals(Car.COMPACT)) {
            if (numberOfAvailableSlots(Car.COMPACT) > 0) {
                compactList.add(car);
                return true;
            }

        } else if (car.getType().equals(Car.MIDSIZE)) {
            if (numberOfAvailableSlots(Car.MIDSIZE) > 0) {
                midSizeList.add(car);
                return true;
            }

        } else if (car.getType().equals(Car.FULL_SIZE)) {
            if (numberOfAvailableSlots(Car.FULL_SIZE) > 0) {
                fullSizeList.add(car);
                return true;
            }
        }
        return false;
    }

    public Car exit(String car, String licence) {

        Car car1 = null;
        if (car.contains(Car.COMPACT)) {
            for (int i = 0; i < compactList.size(); i++) {
                if ( licence.equals(compactList.get(i).getLicense())) {
                    car1 = compactList.get(i);
                    compactList.remove(i);
                }
            }
            return car1;

        } else if (car.contains(Car.MIDSIZE)) {
            for (int i = 0; i < midSizeList.size(); i++) {
                if ( licence.equals(midSizeList.get(i).getLicense())) {
                    car1 = midSizeList.get(i);
                    midSizeList.remove(i);

                }
            }
            return car1;

        } else if (car.contains(Car.FULL_SIZE)) {
            for (int i = 0; i < fullSizeList.size(); i++) {
                if (licence.equals(fullSizeList.get(i).getLicense())) {
                    car1 = fullSizeList.get(i);
                    fullSizeList.remove(i);

                }
            }
            return car1;
        }
        return null;
    }
    }











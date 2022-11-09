package com.techelevator;

public class HotelReservation {
    /*
    Fill in the class details here...
     */
   private String name;
   private int numberOfNights;
   private int nightlyRate;
   private int estimatedTotal;

    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public int getEstimatedTotal() {

        return estimatedTotal = numberOfNights * nightlyRate;
    }

    public int getActualTotal(boolean requireCleaning, boolean usedMinibar) {
        int cleaning = 0;
        int miniBar = 0;

        if (requireCleaning && !usedMinibar) {
            cleaning = 25;
        }
        if (usedMinibar && !requireCleaning) {
            miniBar = 15;
        }
        if (requireCleaning && usedMinibar) {
            miniBar = 15 + 50;
        }
        return getEstimatedTotal() + cleaning + miniBar;
    }

    }



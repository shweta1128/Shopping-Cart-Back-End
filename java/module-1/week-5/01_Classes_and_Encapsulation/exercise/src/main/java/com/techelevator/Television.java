package com.techelevator;

public class Television {
    private boolean isOn  ;
    private int currentChannel = 3 ;
    private int currentVolume = 2 ;

    public boolean isOn(){
        return isOn;
    }
    public int getCurrentChannel(){
        return currentChannel;
    }
    public int getCurrentVolume(){
        return currentVolume;
    }

    public void turnOff(){
        isOn = !isOn;
    }
    public void turnOn(){
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }
    public void changeChannel(int newChannel){

        if (newChannel >= 3 && newChannel <= 18 && isOn ) {
            currentChannel = newChannel;
        }


    }
    public void channelUp(){
        if (currentChannel == 18 && isOn){
            currentChannel = 3;


        } else if (isOn){
            currentChannel ++;
        }

    }
    public void channelDown(){
        if (currentChannel == 3 && isOn){
            currentChannel = 18;
        } else if (isOn){
            currentChannel --;
        }
    }
    public void raiseVolume(){
        if (currentVolume < 10  && isOn){
            currentVolume ++;
        }
    }
    public  void lowerVolume(){
        if (currentVolume > 0 && isOn){
            currentVolume --;
        }

    }

}

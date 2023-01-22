package com.techelevator.model;

public class WishList {
    private int user_id;
    private String name;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public WishList(int user_id, String name) {
        this.user_id = user_id;
        this.name = name;
    }
}

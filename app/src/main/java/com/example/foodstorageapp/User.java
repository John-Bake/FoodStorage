package com.example.foodstorageapp;

public class User {
    private String userName = "";
    private String password = "";

    public User(String userName, String password){this.userName = userName;
    this.password = password;} //only to be able to start the app-Ricardo

    public User(){} //only to be able to start the app-Ricardo

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

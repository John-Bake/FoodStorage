package com.example.foodstorageapp;

public class User {
    private String userName = "";
    private String password = "";
    private String userId = "";

    public User(String userName, String password){this.userName = userName;
    this.password = password;} //only to be able to start the app-Ricardo

    public User(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    public User(){} // Needed to allow User to be sent to database

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}


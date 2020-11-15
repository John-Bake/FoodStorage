package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Query {
    private DatabaseReference appDatabase = FirebaseDatabase.getInstance().getReference();

    public void writeUser(User user) {
        appDatabase.child("users").child("userName").setValue(user);
    }
    public String makeQuery(String userName, String password) {
        String userData = null;
        return userData;
    }
}

package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserWriteQuery implements WriteQuery {
    private User user;
    FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = appDatabase.getReference("FoodStorageApp");

    public UserWriteQuery() {}
    public UserWriteQuery(User user) {
        this.user = user;
    }

    @Override
    public void makeWriteQuery() {
        DatabaseReference currentRef = reference.child("users");
        currentRef.push().setValue(user);
    }
}

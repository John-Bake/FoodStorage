package com.example.foodstorageapp;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemWriteQuery implements WriteQuery {
    private DatabaseItem item;

    FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = appDatabase.getReference("FoodStorageApp").child("users");

    public ItemWriteQuery() {}
    public ItemWriteQuery(StorageItem item) {
        this.item = new DatabaseItem(item);
    }

    @Override
    public void makeWriteQuery() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentUser.getUid();
        DatabaseReference userRef = reference.child(userID).child("items");
        userRef.push().setValue(item);
    }
}

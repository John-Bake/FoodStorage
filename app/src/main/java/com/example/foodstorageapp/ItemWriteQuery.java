package com.example.foodstorageapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemWriteQuery implements WriteQuery {
    private StorageItem item;

    FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = appDatabase.getReference("FoodStorageApp");

    public ItemWriteQuery() {}
    public ItemWriteQuery(StorageItem item) {
        this.item = item;
    }

    @Override
    public void makeWriteQuery() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentUser.getUid();
        DatabaseReference userRef = reference.child("users").child(userID);
        userRef.push().setValue(item);
    }
}

package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemWriteQuery implements WriteQuery {
    private StorageItem item;

    public ItemWriteQuery() {}
    public ItemWriteQuery(StorageItem item) {
        this.item = item;
    }

    @Override
    public void makeWriteQuery() {
        FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
        DatabaseReference appDatabaseRef = appDatabase.getReference().child("item");
        appDatabaseRef.push().setValue(item);
    }
}

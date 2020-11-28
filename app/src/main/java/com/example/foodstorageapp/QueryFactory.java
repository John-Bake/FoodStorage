package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QueryFactory<T> {
    private FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference appDatabaseRef = appDatabase.getReference().child("item");

    public WriteQuery getQuery(T t) {
        if (t instanceof StorageItem) {
            return new ItemWriteQuery();
        }
    }
}

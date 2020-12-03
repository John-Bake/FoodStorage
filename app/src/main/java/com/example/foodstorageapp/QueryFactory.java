package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QueryFactory<T> {
    public WriteQuery getQuery(T t) {
        if (t instanceof StorageItem) {
            return new ItemWriteQuery();
        }
        else if (t instanceof User) {
            return new UserWriteQuery();
        }
        else return null; //added so I could pass the error and could start the app-Ricardo
    }
}

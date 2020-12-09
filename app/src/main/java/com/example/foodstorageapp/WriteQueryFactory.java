package com.example.foodstorageapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteQueryFactory<T> {
    public WriteQuery getQuery(T t) {
        if (t instanceof StorageItem) {
            StorageItem item = new StorageItem((StorageItem)t);
            return new ItemWriteQuery();
        }
        else if (t instanceof User) {
            User user = new User((User) t);
            return new UserWriteQuery(user);
        }
        else return null; //added so I could pass the error and could start the app-Ricardo
    }
}

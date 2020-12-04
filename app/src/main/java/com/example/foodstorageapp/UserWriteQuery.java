package com.example.foodstorageapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserWriteQuery implements WriteQuery {
    private User user;
    private FirebaseAuth authenticator;


    FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = appDatabase.getReference("FoodStorageApp");

    public UserWriteQuery() {}
    public UserWriteQuery(User user) {
        this.user = user;
    }

    @Override
    public void makeWriteQuery() {

        DatabaseReference userRef = reference.child("users");
        userRef.push().setValue(user);
    }
}

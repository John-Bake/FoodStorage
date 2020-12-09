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

import java.util.HashMap;
import java.util.Map;

public class UserWriteQuery implements WriteQuery {
    private User user;

    FirebaseDatabase appDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = appDatabase.getReference("FoodStorageApp");

    public UserWriteQuery() {}
    public UserWriteQuery(User user) {
        this.user = user;
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        user.setUserId(currentUser.getUid());
    }

    @Override
    public void makeWriteQuery() {
        DatabaseReference userRef = reference.child("users");
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentUser.getUid();
        userRef.child (userID).setValue(user);
    }
}

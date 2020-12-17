package com.example.foodstorageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userAuth = FirebaseAuth.getInstance();
    }

    public void authenticateUser(View userLogin) {
        EditText editUserName = (EditText) findViewById(R.id.userEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.userPassword);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        authenticate(userName, password);

    }

    public void authenticate(String userName, String password) {

        userAuth = FirebaseAuth.getInstance();
        userAuth.signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = userAuth.getCurrentUser();
                            String userID = user.getUid();
                            startActivity(new Intent(MainActivity.this, DataEntryForm.class));
                        }
                    }
                });
    }

    public void registerUser(View userRegistration) {
        startActivity(new Intent(MainActivity.this, UserRegistrationActivity.class));
    }

//    //This is only to move from main screen to piechart, will be delete eventually
//    public void nextscreen(View view) {
//        startActivity(new Intent(MainActivity.this, Dashboard.class));
//    }

}
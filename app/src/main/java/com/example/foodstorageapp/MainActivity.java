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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    private FirebaseAuth authenticator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authenticator = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = authenticator.getCurrentUser();
        //updateUI(currentUser);
    }

    public void createUser(View createUser) {
        EditText editUserName = (EditText) findViewById(R.id.userEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.userPassword);
        EditText editPasswordConfirm = (EditText) findViewById(R.id.confirmUserPwd);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        String pwdConfirm = editPasswordConfirm.getText().toString();
        authenticator.createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = authenticator.getCurrentUser();
                        }
                        else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        }
                    }
                });
        FirebaseUser user = authenticator.getCurrentUser();
        UserPresenter currentUser = new UserPresenter();
        //currentUser.register(userName, password, pwdConfirm);



    }

    //This is only to move from main screen to piechart, will be delete eventually
    public void nextscreen(View view) {
        startActivity(new Intent(MainActivity.this, Dashboard.class));
    }

}
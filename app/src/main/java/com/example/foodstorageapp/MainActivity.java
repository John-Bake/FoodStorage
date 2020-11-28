package com.example.foodstorageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createUser(View createUser) {
        Log.d(TAG, "Getting user data");
        EditText editUserName = (EditText) findViewById(R.id.userEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.userPassword);
        EditText editPasswordConfirm = (EditText) findViewById(R.id.confirmUserPwd);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        String pwdConfirm = editPasswordConfirm.getText().toString();
        UserPresenter currentUser = new UserPresenter();
        Log.d(TAG, "Created userPresenter with username: " + userName + " password: " + password);
        //currentUser.register(userName, password, pwdConfirm);



    }

    //This is only to move from main screen to piechart, will be delete eventually
    public void nextscreen(View view) {
        startActivity(new Intent(MainActivity.this, Dashboard.class));
    }

}
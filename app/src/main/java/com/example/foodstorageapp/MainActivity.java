package com.example.foodstorageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createUser(View createUser) {
        EditText editUserName = (EditText) findViewById(R.id.userEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.userPassword);
        EditText editPasswordConfirm = (EditText) findViewById(R.id.confirmUserPwd);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        String pwdConfirm = editPasswordConfirm.getText().toString();
        UserPresenter currentUser = new UserPresenter();
        currentUser.register(userName, password, pwdConfirm);



    }
}
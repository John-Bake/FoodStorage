package com.example.foodstorageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistrationActivity extends AppCompatActivity {

    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
    }

    private boolean validateEmail(String email) {
        boolean validEmail = false;
        if (email.matches(EMAIL_REGEX)) {
            validEmail = true;
        }
        return validEmail;
    }

    private boolean validatePasswordLength(String password) {
        boolean longEnoughPwd = false;
        if (password.length() > 5) {
            longEnoughPwd = true;
        }
        return longEnoughPwd;
    }

    private boolean validatePasswordMatches(String password, String pwdConfirm) {
        boolean passwordsMatch = false;
        if (password.equals(pwdConfirm)) {
            passwordsMatch = true;
        }
        return passwordsMatch;
    }

    public void createUser(View createUser) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("foodstorageapp");
        boolean validAccount = true;

        EditText editUserName = (EditText) findViewById(R.id.registrationEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.registrationPassword);
        EditText editPasswordConfirm = (EditText) findViewById(R.id.confirmUserPwd);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        String pwdConfirm = editPasswordConfirm.getText().toString();

        if (!validateEmail(userName)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
            validAccount = false;
        }
        else if (!validatePasswordLength(password)) {
            Toast.makeText(getApplicationContext(), "Password is too short", Toast.LENGTH_LONG).show();
            validAccount = false;
        }
        else if (!validatePasswordMatches(password, pwdConfirm)) {
            Toast.makeText(UserRegistrationActivity.this, "Passwords don't match", Toast.LENGTH_LONG).show();
            validAccount = false;
        }

        else if (validAccount) {
            UserPresenter currentUser = new UserPresenter();
            currentUser.register(userName, password, pwdConfirm);
            startActivity(new Intent(UserRegistrationActivity.this, DataEntryForm.class));
        }
    }
}
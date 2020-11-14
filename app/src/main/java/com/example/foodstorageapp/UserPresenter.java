package com.example.foodstorageapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;

public class UserPresenter extends AppCompatActivity {
    private boolean loginStatus = false;
    private boolean registrationStatus = false;

    // Constants for shared preferences keys
    public static final String USER_NAME = "name";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PREFS = "UserPref";

    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    SharedPreferences sharedPref;
    // Need to be global so they can be accessed by both methods.
    User user = new User();
    String userName = user.getUserName();
    String password = user.getPassword();

    public void authenticate(String userData) {
        
    }

    public void register(String userName, String password, String pwdConfirm) {
        User currentUser = new User();
        if (userName.matches(EMAIL_REGEX)) {
            currentUser.setUserName(userName);
        }
        else {
            Toast.makeText(getApplicationContext(), "Not a valid email", Toast.LENGTH_LONG).show();
        }
        if (password == pwdConfirm) {
            currentUser.setPassword(password);
        }
        else {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
        }
    }
    private void displayStatus(boolean validated) {

    }

    // Saves current values in shared preferences
    public void saveLogin(View saveLogin) {
        sharedPref = getApplicationContext().getSharedPreferences("UserPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_NAME, userName);
        editor.putString(USER_PASSWORD, password);
        editor.commit();
        // Alert that values have been saved
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
    }

    // Retrieve login credentials from shared preferences
    public void loadLogin(View viewLogin) {
//        EditText editBook = (EditText) findViewById(R.id.editTextBook);
//        EditText editChapter = (EditText) findViewById(R.id.editTextChapter);
//        EditText editVerse = (EditText) findViewById(R.id.editTextVerse);
        sharedPref = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        if (sharedPref.contains(USER_NAME)) {
            user.setUserName(USER_NAME);
        }
        if (sharedPref.contains(USER_PASSWORD)) {
            user.setPassword(USER_PASSWORD);
        }
//        if (sharedPref.contains(USER_VERSE)) {
//            editVerse.setText(sharedPref.getString(USER_VERSE, ""));
//        }
    }
}

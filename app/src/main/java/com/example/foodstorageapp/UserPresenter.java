package com.example.foodstorageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class UserPresenter extends AppCompatActivity {
    private boolean loginStatus = false;
    private boolean registrationStatus = false;
    private FirebaseAuth authenticator;

    // Constants for shared preferences keys
    public static final String USER_NAME = "name";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PREFS = "UserPref";

    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    private static final String TAG = "UserPresenter";

    SharedPreferences sharedPref;
    // Need to be global so they can be accessed by both methods.
    User user = new User();
    String userName = user.getUserName();
    String password = user.getPassword();

    public void authenticate(String userData) {
        
    }

    public void register(String userName, String password, String pwdConfirm) {
        User user = new User(userName, password);
        if (userName.matches(EMAIL_REGEX)) {
            user.setUserName(userName);
            if (password.equals(pwdConfirm)) {
                user.setPassword(password);
                authenticator = FirebaseAuth.getInstance();
                FirebaseUser currentUser = authenticator.getCurrentUser();

                authenticator.createUserWithEmailAndPassword(user.getUserName(), user.getPassword())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("registerUser", "createUserWithEmail:success");
                                    FirebaseUser user = authenticator.getCurrentUser();
                                }
                                else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                }
                            }
                        });

                QueryFactory factory = new QueryFactory();
                WriteQuery saveUser = factory.getQuery(user);
                saveUser.makeWriteQuery();
                
            }
            else {

            }
        }
        else {

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

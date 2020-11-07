package com.example.foodstorageapp;

import android.util.Log;

public class ExpireNotice {
    private static final String TAG = "ExpireNotice";

    private int expireReminderPref = 2;

    public int getExpireReminderPref() {
        return expireReminderPref;
    }

    public void setExpireReminderPref(int expireReminderPref) {
        this.expireReminderPref = expireReminderPref;
    }

    public void setupNotifications(int expireReminderPref) {
        //debug message
        Log.d(TAG, "Setup notification started");
    }
}

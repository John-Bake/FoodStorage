package com.example.foodstorageapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.time.ZonedDateTime;

public class ExpireNotice extends AppCompatActivity {
    private static final String TAG = "ExpireNotice";

    //default reminder for expiration is 2 months before an item expires
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

    //@RequiresApi(api = Build.VERSION_CODES.O)
    private void setAlarm() {
        //alarmService
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long currentTime = ZonedDateTime.now().toInstant().toEpochMilli();
        //long time = System.currentTimeMillis();
        long alarmTime = currentTime + 5;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, broadcast);

        /* refactored to use above the java.time class as there are know issues
        with the java.util.Calendar classes

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), broadcast);
        */
    }
}

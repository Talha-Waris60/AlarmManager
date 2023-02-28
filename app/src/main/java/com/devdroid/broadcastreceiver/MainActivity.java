package com.devdroid.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.time);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.setAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Take time from input and store in int
                int time = Integer.parseInt(((EditText)findViewById(R.id.time)).getText().toString());
                // Current time that input user
                long triggerTime = System.currentTimeMillis()+(time*1000);

                // Intent
                Intent iBroad = new Intent(MainActivity.this, Receiver.class);
                // Make pending Intent
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,100,iBroad,0);
                // Alarm Manager
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
            }
        });


    }
}
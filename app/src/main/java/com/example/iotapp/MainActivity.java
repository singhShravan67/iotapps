package com.example.iotapp;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    TextView tempText, humText, gasText;

    Button autoBtn, manualBtn, m1On, m1Off, m2On, m2Off;

    DatabaseReference sensorRef, controlRef;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI bind
        tempText = findViewById(R.id.temp);
        humText  = findViewById(R.id.hum);
        gasText  = findViewById(R.id.gas);

        autoBtn   = findViewById(R.id.autoBtn);
        manualBtn = findViewById(R.id.manualBtn);
        m1On  = findViewById(R.id.m1On);
        m1Off = findViewById(R.id.m1Off);
        m2On  = findViewById(R.id.m2On);
        m2Off = findViewById(R.id.m2Off);

        // Firebase refs
        sensorRef  = FirebaseDatabase.getInstance().getReference("sensor");
        controlRef = FirebaseDatabase.getInstance().getReference("control");

        createNotificationChannel();

        // 🔄 SENSOR DATA LISTENER
        sensorRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    double temp = snapshot.child("temp").getValue(Double.class);
                    long hum    = snapshot.child("hum").getValue(Long.class);
                    long gas    = snapshot.child("gas").getValue(Long.class);

                    tempText.setText("Temp: " + temp);
                    humText.setText("Humidity: " + hum);
                    gasText.setText("Gas: " + gas);

                    // 🚨 RISK ALERT
                    if (temp > 30 || gas > 350) {
                        showNotification("⚠ Danger!", "High Temp or Gas Detected!");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {}
        });

        // 🔘 BUTTON ACTIONS

        autoBtn.setOnClickListener(v -> {
            controlRef.child("mode").setValue(1); // AUTO
            // highlight
            autoBtn.setBackgroundColor(0xFF42A5F5);
            autoBtn.setTextColor(0xFFFFFFFF);
            manualBtn.setBackgroundColor(0xFF1A1D26);
            manualBtn.setTextColor(0xFF888888);
        });

        manualBtn.setOnClickListener(v -> {
            controlRef.child("mode").setValue(0); // MANUAL
            // highlight
            manualBtn.setBackgroundColor(0xFF42A5F5);
            manualBtn.setTextColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFF1A1D26);
            autoBtn.setTextColor(0xFF888888);
        });

        m1On.setOnClickListener(v -> {
            controlRef.child("m1").setValue(1);
            // highlight
            m1On.setBackgroundColor(0xFF4CAF50);
            m1On.setTextColor(0xFFFFFFFF);
            m1Off.setBackgroundColor(0xFF1A1D26);
            m1Off.setTextColor(0xFF888888);
        });

        m1Off.setOnClickListener(v -> {
            controlRef.child("m1").setValue(0);
            // highlight
            m1Off.setBackgroundColor(0xFFEF5350);
            m1Off.setTextColor(0xFFFFFFFF);
            m1On.setBackgroundColor(0xFF1A1D26);
            m1On.setTextColor(0xFF888888);
        });

        m2On.setOnClickListener(v -> {
            controlRef.child("m2").setValue(1);
            // highlight
            m2On.setBackgroundColor(0xFF4CAF50);
            m2On.setTextColor(0xFFFFFFFF);
            m2Off.setBackgroundColor(0xFF1A1D26);
            m2Off.setTextColor(0xFF888888);
        });

        m2Off.setOnClickListener(v -> {
            controlRef.child("m2").setValue(0);
            // highlight
            m2Off.setBackgroundColor(0xFFEF5350);
            m2Off.setTextColor(0xFFFFFFFF);
            m2On.setBackgroundColor(0xFF1A1D26);
            m2On.setTextColor(0xFF888888);
        });
    }

    // 🔔 NOTIFICATION FUNCTION
    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "iot_channel")
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(1, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "iot_channel",
                    "IOT Alerts",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}   
package com.example.wmp_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EventCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_event);

        // Find the buttons by their IDs
        Button actionButton = findViewById(R.id.actionButton);
        Button sosproButton = findViewById(R.id.sosproButton);
        Button compstudButton = findViewById(R.id.compstudButton);
        Button compsphereButton = findViewById(R.id.compsphereButton);

        // Set onClickListeners for each button
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventJoinActivity();
            }
        });

        sosproButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventJoinActivity();
            }
        });

        compstudButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventJoinActivity();
            }
        });

        compsphereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventJoinActivity();
            }
        });
    }

    // Function to open the EventJoinActivity
    private void openEventJoinActivity() {
        Intent intent = new Intent(this, EventRegister.class);
        startActivity(intent);
    }

    public void BackButton1(View view) {
        Intent intent = new Intent(this, NewsUpdate.class);
        startActivity(intent);
    }
}

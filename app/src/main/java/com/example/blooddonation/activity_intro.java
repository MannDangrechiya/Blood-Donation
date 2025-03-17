package com.example.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_intro extends AppCompatActivity {

    private TextView whiteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);

        // Initialize the Donate Now button
        Button donateNowButton = findViewById(R.id.whiteButton);

        // Set OnClickListener to navigate to another activity (e.g., MainActivity)
        donateNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the main activity or donation form
                Intent intent = new Intent(activity_intro.this, activity_login.class);
                startActivity(intent);
            }
        });

        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_intro.this, activity_login.class));
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity_intro.this, activity_login.class);
                startActivity(intent);
                finish(); // Close the intro activity
            }
        }, 6000);
    }
}
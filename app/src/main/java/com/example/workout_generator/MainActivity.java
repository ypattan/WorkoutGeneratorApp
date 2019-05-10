
package com.example.workout_generator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.Buffer;
import java.util.Random;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        Button generate = findViewById(R.id.generate_button);
        Button ankle = findViewById(R.id.ankleEx_button);

        // Set a click listener on that View
        generate.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent workoutIntent = new Intent(MainActivity.this, WorkoutActivity.class);

                // Start the new activity
                startActivity(workoutIntent);
            }
        });

        ankle.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ankleIntent = new Intent(MainActivity.this, AnkleActivity.class);

                // Start the new activity
                startActivity(ankleIntent);
            }
        });
    }


}
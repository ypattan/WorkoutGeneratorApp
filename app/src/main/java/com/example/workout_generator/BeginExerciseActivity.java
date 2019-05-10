package com.example.workout_generator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BeginExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_begin_exercise);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String workoutName = preferences.getString("Quads", "");
        if(!workoutName.equalsIgnoreCase(""))
        {
            TextView exerciseText = findViewById(R.id.test1);
            exerciseText.setText(workoutName);
        }



    }
}
package com.example.workout_generator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

//SharedPreference usage documentation
//https://stackoverflow.com/questions/3624280/how-to-use-sharedpreferences-in-android-to-store-fetch-and-edit-values
public class WorkoutActivity extends AppCompatActivity {

    String[] quadExercises = {"step ups", "lunges", "kettlebell swing", "figure 8 squats", "bear squat", "curtsy lunge side kick"};
    String[] gluteExercises = {"side lunge curtsy lunge", "hip raises", "chest fly glute bridge", "step ups", "basketball shots", "knee to elbow kickback", "plie squat calf raise", "romanian deadlift", "rolling squat"};
    String[] pushExercises = {"overhead press", "bench press", "incline dumbell press", "push ups", "dips", "asymmetrical push ups", "standing chest fly", "curtsy lunge side rainbow"};
    String[] pullExercises = {"tabletop reverse pike", "knee and elbow push up", "bodyweight rows", "dumbell rows", "bear walk", "bow and arrow squat pull", "up down plank", "reverse plank"};
    String[] coreExercises = {"plank", "side plank", "exercise ball crunches", "mountain climbers", "russian twist", "crunch chop", "wood chop", "dumbell leg scoop", "double leg stretch"};

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_workout);

        generateRandNums();

        //Again button functionality
        Button again = findViewById(R.id.refresh);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandNums();
            }
        });


        //Choose button functionality
        Button choose = findViewById(R.id.choose_button);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent beginWorkoutIntent = new Intent(WorkoutActivity.this, BeginExerciseActivity.class);
                startActivity(beginWorkoutIntent);
            }
        });

    }



    public void generateRandNums() {
        Random rand = new Random();

        quads(rand.nextInt(quadExercises.length));
        glutes(rand.nextInt(gluteExercises.length));
        push(rand.nextInt(pushExercises.length));
        pull(rand.nextInt(pullExercises.length));
        core(rand.nextInt(coreExercises.length));
    }



    public void quads(int x) {
        TextView exerciseText = findViewById(R.id.quads_text);
        String exercise = "Quads";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(exercise,quadExercises[x]).apply();

        exercise += "\n" + quadExercises[x];

        exerciseText.setText(exercise);
    }

    public void glutes(int x) {
        TextView exerciseText = findViewById(R.id.glutes_text);
        String exercise = "Glutes";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(exercise,x).apply();

        exercise += "\n" + gluteExercises[x];

        exerciseText.setText(exercise);
    }


    public void push(int x) {
        TextView exerciseText = findViewById(R.id.push_text);
        String exercise = "Push";
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt(exercise,x);
//        editor.apply();
        exercise += "\n" + pushExercises[x];

        exerciseText.setText(exercise);
    }

    public void pull(int x) {
        TextView exerciseText = findViewById(R.id.pull_text);
        String exercise = "Pull";
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt(exercise,x);
//        editor.apply();

        exercise += "\n" + pullExercises[x];

        exerciseText.setText(exercise);
    }

    public void core(int x) {
        TextView exerciseText = findViewById(R.id.core_text);
        String exercise = "Core";
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt(exercise,x);
//        editor.apply();

        exercise += "\n" + coreExercises[x];

        exerciseText.setText(exercise);
    }
}
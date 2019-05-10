package com.example.workout_generator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

// Timer Implementation
// https://www.youtube.com/playlist?list=PLrnPJCHvNZuB8wxqXCwKw2_NkyEmFwcSd
// https://codinginflow.com/tutorials/android/countdowntimer/part-1-countdown-timer

public class BeginExerciseActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView countDownTextView;
    private Button startpauseButton;
    private Button resetButton;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMilliSec = START_TIME_IN_MILLIS;




    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_begin_exercise);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView exerciseText = findViewById(R.id.exercise_text);
        exerciseText.setText("Quads\n" + preferences.getString("Quads", ""));

        countDownTextView = findViewById(R.id.text_view_countdown);


        startpauseButton = findViewById(R.id.start_pause_button);
        startpauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });


        resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliSec, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliSec = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                startpauseButton.setText("Start");


            }
        }.start();
        timerRunning = true;
        startpauseButton.setText("Pause");

    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        startpauseButton.setText("Start");

    }

    private void resetTimer() {
        timeLeftInMilliSec = START_TIME_IN_MILLIS;
        updateCountDownText();


    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMilliSec / 1000)/ 60;
        int seconds = (int) (timeLeftInMilliSec / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        countDownTextView.setText(timeLeftFormatted);
    }


}
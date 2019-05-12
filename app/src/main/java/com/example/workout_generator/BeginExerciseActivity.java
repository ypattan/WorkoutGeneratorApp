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
    private static final long START_TIME_IN_MILLIS = 45000;

    private TextView countDownTextView;
    private Button startpauseButton;
    private Button resetButton;
    private Button nextButton;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMilliSec = START_TIME_IN_MILLIS;

    int exerciseNum = 0;



    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_begin_exercise);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView exerciseText = findViewById(R.id.exercise_text);
        exerciseText.setText("Quads\n" + preferences.getString("Quads", ""));
        //currExerciseOutput();

        countDownTextView = findViewById(R.id.text_view_countdown);

//        nextButton = findViewById(R.id.next_exercise);
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                currExerciseOutput();
//            }
//        });


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
                startpauseButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.VISIBLE);
            }
        }.start();
        timerRunning = true;
        startpauseButton.setText("Pause");
        resetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        startpauseButton.setText("Start");
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMilliSec = START_TIME_IN_MILLIS;
        updateCountDownText();
        resetButton.setVisibility(View.INVISIBLE);
        startpauseButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMilliSec / 1000)/ 60;
        int seconds = (int) (timeLeftInMilliSec / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        countDownTextView.setText(timeLeftFormatted);
    }

    private void currExerciseOutput () {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView exerciseText = findViewById(R.id.exercise_text);
        if (exerciseNum == 0) {
            exerciseText.setText("Quads\n" + preferences.getString("Quads", ""));
        } else if (exerciseNum == 1) {
            exerciseText.setText("Glutes\n" + preferences.getString("Glutes", ""));
        } else if (exerciseNum == 2) {
            exerciseText.setText("Push\n" + preferences.getString("Push", ""));
        } else if (exerciseNum == 3) {
            exerciseText.setText("Pull\n" + preferences.getString("Pull", ""));
        } else if (exerciseNum == 4) {
            exerciseText.setText("Core\n" + preferences.getString("Core", ""));
        } else {
            doneWithWorkout();
        }

        exerciseNum++;
    }

    private void currExerciseOutput (View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView exerciseText = findViewById(R.id.exercise_text);
        if (exerciseNum == 0) {
            exerciseText.setText("Quads\n" + preferences.getString("Quads", ""));
        } else if (exerciseNum == 1) {
            exerciseText.setText("Glutes\n" + preferences.getString("Glutes", ""));
        } else if (exerciseNum == 2) {
            exerciseText.setText("Push\n" + preferences.getString("Push", ""));
        } else if (exerciseNum == 3) {
            exerciseText.setText("Pull\n" + preferences.getString("Pull", ""));
        } else if (exerciseNum == 4) {
            exerciseText.setText("Core\n" + preferences.getString("Core", ""));
        } else {
            doneWithWorkout();
        }

        exerciseNum++;
    }

    public void doneWithWorkout() {

    }

}
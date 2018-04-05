package com.example.android.workout;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button workoutSchedule;
    Button aboutBut;
    Button weightButton;
    Button goalButton;
    //TODO Instead of creating a textview of workout categories, create several buttons that will link to textviews

    public final void openWorkoutCategories(View view){
        Intent intent = new Intent(this, DisplayWorkoutCategories.class);
        startActivity(intent);
    }

    public final void openAbout(View view){
        Intent intent = new Intent(this,DisplayAbout.class);
        startActivity(intent);
    }
    public final void openWeight(View view){
        Intent intent = new Intent(this,DisplayAbout.class);
        startActivity(intent);
    }

    public final void openGoals(View view){
        Intent intent = new Intent(this,WorkoutGoal.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Pulls up workout schedule
        workoutSchedule = (Button)findViewById(R.id.workout_Schedule_Button);
        //Pulls up about me page TODO add to about_me
        aboutBut = (Button)findViewById(R.id.about_me);
        //Pulls up weight graph
        weightButton = (Button)findViewById(R.id.workout_Weight_Button);

        goalButton = (Button)findViewById(R.id.goal_button);


        workoutSchedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openWorkoutCategories(v);
                //workoutSchedule.setText("AfterClick");

            }
        });
        aboutBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openAbout(v);
            }
        });

        weightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openWeight(v);
            }
        });

        goalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openGoals(v);
            }
        });



        NotificationUtils notificationUtils = new NotificationUtils(this);

        notificationUtils.launchNotification();

    }

}

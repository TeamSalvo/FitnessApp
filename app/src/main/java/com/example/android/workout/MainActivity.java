package com.example.android.workout;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button workoutSchedule;
    Button aboutBut;
    Button weightButton;
    Button userInfoButton;
    Button goalButton;
    Button settingsButton;

    TextView title;
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
        Intent intent = new Intent(this,DisplayWeightGraph.class);
        startActivity(intent);
    }

    public final void openUserInfo(View view){
        Intent intent = new Intent(this,UserInfo.class);
        startActivity(intent);
    }

    public final void openGoals(View view){
        Intent intent = new Intent(this,WorkoutGoal.class);
        startActivity(intent);
    }

    public final void openSettings(View view){
        Intent intent = new Intent(this,DisplaySettings.class);
        startActivity(intent);
    }


    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.main_title);


        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawerLayout);

        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();

        //Pulls up workout schedule
        workoutSchedule = (Button)findViewById(R.id.workout_Schedule_Button);
        //Pulls up about me page TODO add to about_me
        aboutBut = (Button)findViewById(R.id.about_me);
        //Pulls up weight graph
        weightButton = (Button)findViewById(R.id.workout_Weight_Button);

        userInfoButton = (Button)findViewById(R.id.workout_User_Info_Button);

        goalButton = (Button)findViewById(R.id.goal_button);

        settingsButton = (Button)findViewById(R.id.settings_button);


        title.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Uri uri = Uri.parse("https://github.com/TeamSalvo/FitnessApp"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

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

        userInfoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openUserInfo(v);
            }
        });

        goalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openGoals(v);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openSettings(v);
            }
        });



    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}

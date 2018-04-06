package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CardioProgram extends AppCompatActivity {
    ListView cardioListView;
    String[] workouts = {"Mountain Climbers", "Jumping Jacks", "Streching"};
    String[] desc = {"workout1", "workout2", "workout3"};
    Integer[] imgid={R.drawable.girl_weightt,R.drawable.girl_one, R.drawable.girl_one};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_program);

        cardioListView = findViewById(R.id.cardioListView);
        CustomListView customListView = new CustomListView(this,workouts, desc, imgid);
        cardioListView.setAdapter(customListView);
    }
}

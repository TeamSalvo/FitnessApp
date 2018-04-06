package com.example.android.workout.CardioProgramDir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.workout.CustomListView;
import com.example.android.workout.R;

public class CardioProgram extends AppCompatActivity {
    private ListView cardioListView;
    private String[] workouts = {"Test"};
    private String[] desc = {"Test"};
    private Integer[] imgid={R.drawable.girl_weightt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_program);

        cardioListView = findViewById(R.id.cardioListView);
        CustomListView customListView = new CustomListView(this,workouts, desc, imgid);
        cardioListView.setAdapter(customListView);
    }
}

package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

public class DisplayPullA extends AppCompatActivity {
    PPLExercises pullPPL;

    TableLayout tableLayout;
    TextView pullTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pull);

        tableLayout = findViewById(R.id.tablelayout);
        pullTitle = findViewById(R.id.pullTitle);

        pullTitle.setText(R.string.pullTitle);
    }
}

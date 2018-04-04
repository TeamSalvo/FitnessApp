package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.workout.PPLProgram.DisplayPPLProgram;

public class DisplayWorkoutCategories extends AppCompatActivity {
    Button pplBut;
    Button strongBut;
    Button cardioBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_workout_categories);

        pplBut = findViewById(R.id.ppl_button);
        strongBut = findViewById(R.id.strongLift_button);
        cardioBut = findViewById(R.id.cardio_button);

        pplBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openPPLProgram(v);

            }
        });

        strongBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openStrongLiftProgram(v);

            }
        });

        cardioBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openCardioProgram(v);

            }
        });
    }

    public final void openPPLProgram(View view){
        Intent intent = new Intent(this, DisplayPPLProgram.class);
        startActivity(intent);
    }

    public final void openStrongLiftProgram(View view){
        Intent intent = new Intent(this, StrongLift.class);
        startActivity(intent);
    }

    public final void openCardioProgram(View view){
        Intent intent = new Intent(this, Cardio.class);
        startActivity(intent);
    }
}

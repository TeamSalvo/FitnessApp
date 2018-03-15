package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayWorkoutCategories extends AppCompatActivity {
    Button pplBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_workout_categories);

        pplBut = (Button)findViewById(R.id.ppl_button);

        pplBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openPPLProgram(v);

            }
        });
    }

    public final void openPPLProgram(View view){
        Intent intent = new Intent(this, DisplayPPLProgram.class);
        startActivity(intent);
    }
}

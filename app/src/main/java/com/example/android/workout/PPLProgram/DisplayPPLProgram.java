package com.example.android.workout.PPLProgram;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.workout.R;

public class DisplayPPLProgram extends AppCompatActivity {

    Button aboutPPLBut;
    Button intermediateProgram;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pplprogram);

        aboutPPLBut = (Button)findViewById(R.id.about_ppl);
        aboutPPLBut.setText("About PPL Program");
        aboutPPLBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openAboutPPL(v);


            }
        });

        intermediateProgram = (Button)findViewById(R.id.intermediate_program);
        intermediateProgram.setText("Intermediate Program");
        intermediateProgram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openInterProgram(v);

            }
        });

    }

    public final void openAboutPPL(View view){
        Intent intent = new Intent(this,DisplayAboutPPL.class);
        startActivity(intent);
    }
    public final void openInterProgram(View view){
        Intent intent = new Intent(this,DisplayPPLInter.class);
        startActivity(intent);
    }
}

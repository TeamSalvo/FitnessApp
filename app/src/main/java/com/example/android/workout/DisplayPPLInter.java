package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayPPLInter extends AppCompatActivity {
    Button pushABut;
    Button pullABut;
    Button legsABut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pplinter);

        pushABut = findViewById(R.id.pushA_button);
        pushABut.setText(R.string.pushA);

        pullABut = findViewById(R.id.pullA_button);
        pullABut.setText(R.string.pullA);

        legsABut = findViewById(R.id.legsA_button);
        legsABut.setText(R.string.legsA);

        legsABut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openLegsA(v);

            }
        });


        pushABut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openPushA(v);

            }
        });
    }

    public final void openLegsA(View view){
        Intent intent = new Intent(this, DisplayLegsA.class);
        startActivity(intent);

    }
    public final void openPushA(View view){
        Intent intent = new Intent(this, DisplayPushA.class);
        startActivity(intent);

    }
}

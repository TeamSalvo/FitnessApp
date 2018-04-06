package com.example.android.workout.CardioProgramDir;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.workout.CardioProgramDir.CardioProgram;
import com.example.android.workout.R;

public class Cardio extends AppCompatActivity {
    private Button cardioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);

        cardioButton = findViewById(R.id.cardio_Button);


        Drawable jogImage = getResources().getDrawable(R.drawable.jogging_cardio);
        cardioButton.setBackgroundDrawable(jogImage);
        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCardio(view);
            }
        });
    }

    public final void openCardio(View view){
        Intent intent = new Intent(this,CardioProgram.class);
        startActivity(intent);
    }
}

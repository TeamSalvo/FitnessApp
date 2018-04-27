package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MaxRepCalc extends AppCompatActivity {
    NumberPicker numPick;
    EditText maxReps;
    Button calculateBut;
    TextView maxRep100;
    TextView maxRep90;
    TextView maxRep80;
    TextView maxRep70;
    TextView maxRep60;


    int pickedNum =1;
    int inMaxRep = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_rep_calc);
        maxReps = findViewById(R.id.maxRep);
        numPick = findViewById(R.id.numberPicker);
        calculateBut = findViewById(R.id.calculateButton);
         maxRep100 = findViewById(R.id.maxRep100);

        maxRep90 = findViewById(R.id.maxRep90);
        maxRep80 = findViewById(R.id.maxRep80);
        maxRep70 = findViewById(R.id.maxRep70);

        maxRep60 = findViewById(R.id.maxRep60);


        numPick.setMinValue(1);
        numPick.setMaxValue(12);
        numPick.setOnValueChangedListener(onValueChangeListener);

        calculateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inMaxRep = Integer.parseInt(maxReps.getText().toString());
                updateText();
            }
        });

    }
    void updateText(){
        double max100;
        double max90;
        double max80;
        double max70;
        double max60;
        if(maxReps == null){
            inMaxRep = 1;
        }
        if (pickedNum == 1){
            max100 = inMaxRep;
            max90 = inMaxRep*.90;
            max80 = inMaxRep*.80;
            max70 = inMaxRep*.70;
            max60 = inMaxRep*.60;
            maxRep100.setText(Double.toString(Math.floor(max100))+ " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }

        if (pickedNum == 2){
            max100 = inMaxRep*(1 + (2/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 3){
            max100 = inMaxRep*(1 + (3/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 4){
            max100 = inMaxRep*(1 + (4/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 5){
            max100 = inMaxRep*(1 + (5/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 6){
            max100 = inMaxRep*(1 + (6/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 7){
            max100 = inMaxRep*(1 + (7/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 8){
            max100 = inMaxRep*(1 + (8/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 9){
            max100 = inMaxRep*(1 + (9/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 10){
            max100 = inMaxRep*(1 + (10/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 11){
            max100 = inMaxRep*(1 + (11/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }
        if (pickedNum == 12){
            max100 = inMaxRep*(1 + (12/30.0));
            max90 = max100*.90;
            max80 = max100*.80;
            max70 = max100*.70;
            max60 = max100*.60;
            maxRep100.setText(Double.toString(Math.floor(max100)) + " lbs");
            maxRep90.setText(Double.toString(Math.floor(max90))+ " lbs");
            maxRep80.setText(Double.toString(Math.floor(max80))+ " lbs");
            maxRep70.setText(Double.toString(Math.floor(max70))+ " lbs");
            maxRep60.setText(Double.toString(Math.floor(max60))+ " lbs");
        }



    }
    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            pickedNum = numberPicker.getValue();
        }
    };
}

package com.example.android.workout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayWeightGraph extends AppCompatActivity {

    Button calculateBMI;
    Double weight = 0.0;
    Double height = 0.0;
    Double BMI = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weight_graph);

        calculateBMI = findViewById(R.id.button_CalculateBMI);

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EnterUserHeight(v);

            }
        });
    }

    public final void EnterUserHeight(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Height");
        final EditText input = new EditText(this);
        builder.setMessage("Please enter your height in inches.");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.getText().toString()!= null){
                    height = Double.parseDouble(input.getText().toString());
                }
                EnterUserWeight(view);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    public final void EnterUserWeight(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Weight");
        final EditText input = new EditText(this);
        builder.setMessage("Please enter your weight in lbs.");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.getText().toString()!=null){
                    weight = Double.parseDouble(input.getText().toString());
                }
                calculateBMI();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void calculateBMI(){
        BMI = ((weight/(height*height))*703);
        BMI = Math.round(BMI*10.0)/10.0;
        TextView textView = (TextView)findViewById(R.id.view_BMI);
        textView.setText(BMI.toString());
        if(BMI < 12.5){
            textView.setTextColor(Color.RED);
        }
        else if (BMI >= 12.5 && BMI < 18.5){
            textView.setTextColor(Color.BLUE);
        }
        else if(BMI >= 18.5 && BMI < 25){
            textView.setTextColor(Color.GREEN);
        }
        else if(BMI >= 25 && BMI < 30){
            textView.setTextColor(Color.BLUE);
        }
        else if(BMI >= 30){
            textView.setTextColor(Color.RED);
        }
    }
}

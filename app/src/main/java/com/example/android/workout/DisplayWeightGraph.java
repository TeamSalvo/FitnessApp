package com.example.android.workout;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DisplayWeightGraph extends AppCompatActivity {

    Button calculateBMI;
    Button addDataPoint;
    Double weight = 0.0;
    Double height = 0.0;
    Double BMI = 0.0;
    Double mGoalWeight = 0.0;
    int dataPoints = 0;

    LineGraphSeries<DataPoint> series;
    ArrayList<Double> weights = new ArrayList<Double>();


    GraphView graph;

    String userInfoString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weight_graph);

        calculateBMI = findViewById(R.id.button_CalculateBMI);
        addDataPoint = findViewById(R.id.button_AddDataPoint);

        graph = (GraphView)findViewById(R.id.graph);
        graph.getViewport().setXAxisBoundsManual(true);

        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinX(5);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);

        createDemoData();
        readFile();
        initGraph(graph);

        addDataPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddDataPoint(v);
            }
        });
        calculateBMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EnterUserHeight(v);
            }
        });
    }
    private void createDemoData(){
        try {
            File checkFile = getApplicationContext().getFileStreamPath("userWeightData.txt");
            if(!checkFile.exists()){
                FileOutputStream file = openFileOutput("userWeightData.txt",MODE_PRIVATE);
                OutputStreamWriter outputFile = new OutputStreamWriter(file);

                outputFile.write(210+"\n");
                outputFile.write(212+"\n");
                outputFile.write(210.82+"\n");
                outputFile.write(210.72+"\n");
                outputFile.write(212+"\n");
                outputFile.write(213.87+"\n");
                outputFile.write(212.6+"\n");
                outputFile.write(215.123+"\n");
                outputFile.write(210.2+"\n");

                outputFile.flush();
                outputFile.close();
            }
        } catch (Exception e) {
            Toast.makeText(DisplayWeightGraph.this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void readFile(){
        weights.clear();

        File file = getApplicationContext().getFileStreamPath("userWeightData.txt");
        File goalFile = getApplicationContext().getFileStreamPath("GoalWeight.txt");
        String lineFromFile;
        String goalWeight;

        if(file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("userWeightData.txt")));
                while((lineFromFile = reader.readLine())!= null){
                    weights.add(Double.parseDouble(lineFromFile));
                }
            }catch (Exception e){
                Toast.makeText(DisplayWeightGraph.this, e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        if(goalFile.exists()){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("GoalWeight.txt")));
                goalWeight = reader.readLine();
                mGoalWeight = Double.parseDouble(goalWeight);

            }catch(Exception e){
                Toast.makeText(DisplayWeightGraph.this, e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void saveFile(){
        try {
            FileOutputStream file = openFileOutput("userWeightData.txt",MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for(Double tmp:weights){
                outputFile.write(tmp+"\n");
            }

            outputFile.flush();
            outputFile.close();

            Toast.makeText(DisplayWeightGraph.this, "Saved",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(DisplayWeightGraph.this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void initGraph(GraphView graph){
        dataPoints = weights.size();
        double x,y;
        x=0;
        series = new LineGraphSeries<DataPoint>();
        series.setThickness(20);
        series.setTitle("Weight");
        for(Double i: weights){
            x = x + 1;
            y = i;
            series.appendData(new DataPoint(x,y),true, dataPoints);
        }
        graph.addSeries(series);
    }

    private void addToGraph(Double y){
        dataPoints++;
        double x = series.getHighestValueX()+1;
        series.appendData(new DataPoint(x,y),true, dataPoints);
        graph.addSeries(series);
    }

    public final void RemoveDataPoint(final View view){

    }

    public final void AddDataPoint(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Data Point");
        final EditText input = new EditText(this);
        builder.setMessage("Please enter your weight in lbs.");
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                weights.add(Double.parseDouble(input.getText().toString()));
                addToGraph(Double.parseDouble(input.getText().toString()));
                saveFile();
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
    public final void EnterUserHeight(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Height");
        final EditText input = new EditText(this);
        builder.setMessage("Please enter your height in inches.");
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                height = Double.parseDouble(input.getText().toString());
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
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                weight = Double.parseDouble(input.getText().toString());
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
        textView.setText(BMI+"");
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

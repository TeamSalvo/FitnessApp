package com.example.android.workout;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class DisplayPushA extends AppCompatActivity {
    TextView pushATitle;
    //GridView gridView;
    TableLayout tableLayout;
    PPLExercises pushPPL;
    ArrayList<PPLExercises> pushArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_push);

        pushATitle = (TextView)findViewById(R.id.pushATitle);
        pushATitle.setText(R.string.pushTitle);

        //gridView = (GridView)findViewById(R.id.theGrid);
        tableLayout = (TableLayout)findViewById(R.id.pushTable);
        //Input from a text file containing exercise program
        String workoutExercises = "";
        try {
            InputStream in = getAssets().open("pushExercises.txt");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            workoutExercises = new String(buffer);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        // Added each workout and it's stuff to an array
        String[] strArray = workoutExercises.split("[,\\n]+");

        String exercise = "";
        String sets = "";
        String reps = "";
        String rest = "";
        if (strArray.length != 0) {
            for (int i = 0; i < strArray.length; i++) {
                if (i % 4 == 0){
                    exercise = strArray[i];
                    //System.out.println("Exercise: " + exercise );
                }
                else if (i % 4 == 1){
                    sets = strArray[i];
                    //System.out.println("Sets: " + sets);
                }
                else if (i % 4 == 2){
                    reps = strArray[i];
                    //System.out.println("Reps: " + reps);
                }
                else if (i % 4 == 3){
                    rest = strArray[i];
                    //System.out.println("Rest: " + rest);
                    pushPPL = new PPLExercises(exercise, sets, reps, rest);
                    pushArray.add(pushPPL);
                }
            }
        }
        tableStuff(pushArray);
    }

    //Add exercise items to the table
    public void tableStuff(ArrayList<PPLExercises> pushArray){
        PPLExercises push;
        for (int i = 0; i < pushArray.size(); i++) {
            push = pushArray.get(i);
            String exercise = push.getExercise();
            String sets = push.getSets();
            String reps = push.getReps();
            String rest = push.getRest();

            TextView exerciseText;
            TextView setsText;
            TextView repsText;
            TextView restText;
            int textSize = 18;
            int leftRightPadding = 15;
            String rowText = String.format("%30s %10s %10s %10s ", exercise, sets, reps, rest);

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            //row.setPadding(50,50,50,50);
            exerciseText = new TextView(this);
            exerciseText.setText(exercise);
            exerciseText.setTextSize(textSize);
            exerciseText.setPadding(leftRightPadding, 25, leftRightPadding, 25);
            row.addView(exerciseText);

            setsText = new TextView(this);
            setsText.setText(sets);
            setsText.setPadding(leftRightPadding, 25, leftRightPadding, 25);
            setsText.setTextSize(textSize);
            row.addView(setsText);

            repsText = new TextView(this);
            repsText.setText(reps);
            repsText.setPadding(leftRightPadding, 25, leftRightPadding, 25);
            repsText.setTextSize(textSize);
            row.addView(repsText);

            restText = new TextView(this);
            restText.setText(rest);
            restText.setPadding(leftRightPadding, 25, leftRightPadding, 25);
            restText.setTextSize(textSize);
            row.addView(restText);
            tableLayout.addView(row, i);

        }
    }
}

package com.example.android.workout;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.workout.goalObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.text.InputType.TYPE_DATETIME_VARIATION_DATE;

public class WorkoutGoal extends AppCompatActivity {

    LinearLayout layout;
    Button addGoalButton;
    ProgressBar achievementProgress;
    String goalName = null;
    Integer desiredGoal =  null;
    Date goalDate = null;
    ArrayList <goalObject> goalList = new ArrayList <>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_goal);

        layout = findViewById(R.id.vertLinLayout);
        addGoalButton = findViewById(R.id.addGoal);
        achievementProgress = findViewById(R.id.progressBar);

        addGoalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                addGoalDialog(v);
                goalObject newGoal = new goalObject(goalName, desiredGoal, goalDate);
                goalName = null;
                desiredGoal = null;
                goalDate = null;
                if (newGoal.goalName != null)
                {
                    goalList.add(newGoal);
                    setUpVertLayout(v);
                }
            }
        });
    }

    public final void addGoalDialog(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Goal Name");
        final EditText input = new EditText(this);
        builder.setMessage("Enter The Name of Your Goal.");
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goalName = input.getText().toString();
                setDesiredAmount(view);
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

    public final void setDesiredAmount(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Desired Goal");
        final EditText input = new EditText(this);
        builder.setMessage("Enter How Many of this Goal You Would Like To Achieve.");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                desiredGoal = Integer.parseInt(input.getText().toString());
                setCompletionDate(view);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goalName = null;
                dialog.cancel();
            }
        });
        builder.show();
    }

    public final void setCompletionDate(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Desired Day");
        final EditText input = new EditText(this);
        builder.setMessage("What Day Would You Like to Achieve Your Goal? (MM/dd/yyyy)");
        input.setInputType(InputType.TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_DATE);
        builder.setView(input);
        builder.setPositiveButton("FINISH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    goalDate = formatter.parse(input.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goalName = null;
                desiredGoal = null;
                dialog.cancel();
            }
        });
        builder.show();
    }

    public final void setUpVertLayout(View view)
    {
        layout.removeAllViews();
        for(goalObject gO : goalList)
        {
            LinearLayout l = new LinearLayout(this);
            l.setOrientation(LinearLayout.HORIZONTAL);
            l.addView(gO.getRemoveGoal());
            TextView tv = null;
            tv.setText(gO.getGoalName());
            l.addView(tv);
            l.addView(gO.getDecrementAchieved());
            TextView tev = null;
            tev.setText(gO.getGoalAchieved());
            l.addView(tev);
            l.addView(gO.getIncrementAchieved());
            TextView tve = null;
            tve.setText(gO.getDesiredGoal());
            l.addView(tve);
            layout.addView(l);

        }
    }
}

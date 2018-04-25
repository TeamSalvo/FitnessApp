package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class GoalObject extends AppCompatActivity {

    Button removeGoal;
    Button decrementButton;
    Button incrementButton;
    TextView goalName;
    TextView goalMet;
    TextView goalDesired;
    Date completionDate;
    LinearLayout layoutView;
    Boolean deleteGoal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_object);
        removeGoal = findViewById(R.id.removeGoalButton);
        decrementButton = findViewById(R.id.decrementButton);
        incrementButton = findViewById(R.id.incrementButton);
        goalName = findViewById(R.id.goalName);
        goalMet = findViewById(R.id.metGoal);
        goalDesired = findViewById(R.id.desiredGoal);
        layoutView = findViewById(R.id.layoutView);

        removeGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteGoal = true;

            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Integer tempInt = Integer.parseInt(goalMet.toString());
                if (tempInt != 0)
                {
                    tempInt--;
                }
                goalMet.setText(tempInt.toString());

            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Integer tempInt = Integer.parseInt(goalMet.toString());
                tempInt++;
                goalMet.setText(tempInt.toString());

            }
        });
    }

    void setGoalName(String s)
    {
        goalName.setText(s);
    }

    void setGoalMet(String s)
    {
        goalMet.setText(s);
    }

    void setGoalDesired(String s)
    {
        goalDesired.setText(s);
    }

    void setGoalDate(Date d)
    {
        completionDate = d;
    }

    String getGoalName()
    {
        return goalName.toString();
    }

    Boolean getDeleteGoal()
    {
        return deleteGoal;
    }

    LinearLayout getLayoutView()
    {
        return layoutView;
    }
}


/*
public class goalObject {
    Button removeGoal;
    String goalName;
    Button decrementAchieved;
    Integer goalAchieved;
    Button incrementAchieved;
    Integer desiredGoal;
    Date completionDate;
    Boolean deleteGoal;


    goalObject(String name, Integer desired, Date complete)
    {
        goalName = name;
        goalAchieved = 0;
        desiredGoal = desired;
        completionDate = complete;
        deleteGoal = false;
        //decrementAchieved.setEnabled(false);
        //removeGoal.setText("x");
        //decrementAchieved.setText("-");
        //incrementAchieved.setText("+");

/*
        removeGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteGoal = true;

            }
        });

        decrementAchieved.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goalAchieved--;

            }
        });

        incrementAchieved.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goalAchieved++;
                if(!decrementAchieved.isEnabled()) decrementAchieved.setEnabled(true);

            }
        });

    }

            Button getRemoveGoal()
            {
            return removeGoal;
            }

            String getGoalName()
            {
            return goalName;
            }

            Button getDecrementAchieved()
            {
            return decrementAchieved;
            }

            Integer getGoalAchieved()
            {
            return goalAchieved;
            }

            Button getIncrementAchieved()
            {
            return incrementAchieved;
            }

            Integer getDesiredGoal()
            {
            return desiredGoal;
            }


            }
 */
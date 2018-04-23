package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GoalObject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_object);
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
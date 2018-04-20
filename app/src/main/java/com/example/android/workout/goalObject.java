package com.example.android.workout;

import android.widget.Button;

import java.util.Date;

/**
 * Created by jesse on 04/19/2018.
 */

public class goalObject {
    Button removeGoal;
    String goalName;
    Button decrementAchieved;
    Integer goalAchieved;
    Button incrementAchieved;
    Integer desiredGoal;
    Date completionDate;

    goalObject(String name, Integer desired, Date complete)
    {
        goalName = name;
        goalAchieved = 0;
        desiredGoal = desired;
        completionDate = complete;
    }
}

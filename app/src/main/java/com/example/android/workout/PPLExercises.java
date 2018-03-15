package com.example.android.workout;

/**
 * Created by Kent on 2/24/2018.
 */

public class PPLExercises {
    String exercise;
    String sets;
    String reps;

    String rest;

    public PPLExercises(String exercise, String sets, String reps, String rest){
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
    }

    public String getExercise() {
        return exercise;
    }

    public String getReps() {
        return reps;
    }

    public String getRest() {
        return rest;
    }

    public String getSets() {
        return sets;
    }


}

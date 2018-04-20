package com.example.android.workout.CardioProgramDir;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.workout.CustomListView;
import com.example.android.workout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CardioProgram extends AppCompatActivity {
    private ListView cardioListView;
    String[] workouts;
    String[] desc;
    Button restButton;

    private Integer[] imgid={R.drawable.jumping_jacks,R.drawable.mountain_climbers,R.drawable.punches,R.drawable.girl_one, R.drawable.girl_one, R.drawable.girl_one};

    ArrayList<String> numberList = new ArrayList<>();
    //timer------------------------------------------------------------------------------------
    TextView countdownText;
    Button countdownButton;
    Button resetButton;
    CountDownTimer countDownTimer;

    int initialTime = 60000;
    long timeLeftInMilliseconds = initialTime;

    boolean timerRunning = false;
    //timer------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_program);
        cardioListView = findViewById(R.id.cardioListView);
        restButton = findViewById(R.id.cardioRestButton);
        //Add values to workouts,desc, imgid
        //Make sure that the length of each array is the same. workouts[1]=desc[1]=imgid[1]

        //Read in values from text files

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupRestTimer(view);
            }
        });
        //Make the customListView
        updateEverything();
    }

    void updateEverything(){
        get_json();
        CustomListView customListView = new CustomListView(this,workouts, desc, imgid);
        cardioListView.setAdapter(customListView);
    }





    //timer------------------------------------------------------------------------------------
    public void popupRestTimer(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.timer_pop_up,null);
        countdownText = (TextView) mView.findViewById(R.id.cardio_countdown_text);
        TextView restText = (TextView) mView.findViewById(R.id.cardio_rest_text);
        countdownButton= (Button) mView.findViewById(R.id.cardio_countdown_button);
        resetButton = (Button) mView.findViewById(R.id.cardio_reset_button);

        updateTimer();
        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                resetTimer();
                //timerRunning = false;
                countdownButton.setText("Start");

            }
        });
        builder.setView(mView);
        builder.show();

    }

    public void startStop(){
        if(timerRunning){
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countdownButton.setText("Pause");
        timerRunning = true;
        resetButton.setVisibility(View.VISIBLE);
    }
    public void stopTimer(){
        countDownTimer.cancel();
        countdownButton.setText("Start");
        timerRunning = false;

    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds/60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;
        timeLeftText = ""+ minutes;
        timeLeftText +=":";
        if(seconds < 10) timeLeftText +="0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }

    public void resetTimer(){
        timeLeftInMilliseconds = initialTime;
        updateTimer();
    }

    //Timer-----------------------------------------------------------------------
    public void get_json(){
        String json;
        try{
            InputStream is = getAssets().open("cardioExercises.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            workouts = new String[jsonArray.length()];
            desc = new String[jsonArray.length()];

            String exercise;
            ArrayList<JSONObject> jsonStuff = new ArrayList<>();
            for (int i =0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                workouts[i] = obj.getString("Exercise");
                desc[i] = obj.getString("Description");
                //jsonStuff.add(obj);
            }


            //System.out.println( jsonStuff.get(1).getString("Exercise"));
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}

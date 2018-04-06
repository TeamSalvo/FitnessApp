package com.example.android.workout.CardioProgramDir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.workout.CustomListView;
import com.example.android.workout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CardioProgram extends AppCompatActivity {
    private ListView cardioListView;
    String[] workouts;
    String[] desc;
    private Integer[] imgid={R.drawable.jumping_jacks,R.drawable.mountain_climbers,R.drawable.punches,R.drawable.girl_one, R.drawable.girl_one, R.drawable.girl_one};

    ArrayList<String> numberList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_program);
        cardioListView = findViewById(R.id.cardioListView);

        get_json();
        //Add values to workouts,desc, imgid
        //Make sure that the length of each array is the same. workouts[1]=desc[1]=imgid[1]

        //Read in values from text files






        //Make the customListView
        CustomListView customListView = new CustomListView(this,workouts, desc, imgid);
        cardioListView.setAdapter(customListView);
    }

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

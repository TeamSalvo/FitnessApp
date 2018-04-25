package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class UserInfo extends AppCompatActivity {

    Button buttonSave;
    String mHeight="";
    String mWeight="";
    String mGoalWeight="";

    public final void openMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public final void getInfo(){
        mHeight=R.id.user_height+"";
        mWeight=R.id.user_weight+"";
        mGoalWeight=R.id.user_goal_weight+"";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        buttonSave = (Button)findViewById(R.id.button_saveUserInfo);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getInfo();
                saveFile();
                openMain(v);
            }
        });
    }
    private void saveFile(){
        try {
            FileOutputStream file_GoalWeight = openFileOutput("GoalWeight.txt",MODE_PRIVATE);
            FileOutputStream file_UserWeight = openFileOutput("UserWeight.txt",MODE_PRIVATE);
            FileOutputStream file_UserHeight = openFileOutput("UserHeight.txt",MODE_PRIVATE);
            OutputStreamWriter outputFile_GoalWeight = new OutputStreamWriter(file_GoalWeight);
            OutputStreamWriter outputFile_UserWeight = new OutputStreamWriter(file_UserWeight);
            OutputStreamWriter outputFile_UserHeight = new OutputStreamWriter(file_UserHeight);


            outputFile_GoalWeight.write(mGoalWeight+"\n");
            outputFile_UserWeight.write(mWeight+"\n");
            outputFile_UserHeight.write(mHeight+"\n");

            outputFile_GoalWeight.flush();
            outputFile_UserWeight.flush();
            outputFile_UserHeight.flush();

            outputFile_GoalWeight.close();
            outputFile_UserWeight.close();
            outputFile_UserHeight.close();

            Toast.makeText(UserInfo.this, "User Info Saved",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(UserInfo.this, "Error: User Info Failed to Save",Toast.LENGTH_LONG).show();
        }
    }
}

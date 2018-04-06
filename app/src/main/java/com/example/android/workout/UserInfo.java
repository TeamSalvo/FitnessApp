package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfo extends AppCompatActivity {

    Button buttonSave;
    int mHeight=0;
    int mWeight=0;
    int mGoalWeight=0;

    public final void openMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public final void getInfo(){
        mHeight=R.id.user_height;
        mWeight=R.id.user_weight;
        mGoalWeight=R.id.user_goal_weight;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        buttonSave = (Button)findViewById(R.id.button_saveUserInfo);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getInfo();
                openMain(v);
            }
        });
    }
}

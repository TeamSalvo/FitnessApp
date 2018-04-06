package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    public void showToast(View view){
        Toast.makeText(this, "User Info Saved", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        buttonSave = (Button)findViewById(R.id.button_saveUserInfo);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getInfo();
                showToast(v);
                openMain(v);
            }
        });
    }
}

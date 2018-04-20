package com.example.android.workout;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class DisplaySettings extends AppCompatActivity {
    TextView settingTitle;
    TextView settingDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_settings);

        Switch vibrateSwitch = new Switch(this);
        Button testNotification = new Button(this);
        final NotificationUtils notificationUtils = new NotificationUtils(this);

        //if (Build.VERSION.SDK_INT >= 21) {
        //    vibrateSwitch.setShowText(true);
        //}

        //vibrateSwitch = (Switch)findViewById(R.id.vibrate_Switch);

        //testNotification = (Button)findViewById(R.id.launch_notification);

        vibrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                notificationUtils.updateVibrate(isChecked);
            }
        });

        testNotification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                notificationUtils.launchNotification();
                //workoutSchedule.setText("AfterClick");

            }
        });


    }
}

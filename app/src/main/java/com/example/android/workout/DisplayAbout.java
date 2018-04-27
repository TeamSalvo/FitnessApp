package com.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAbout extends AppCompatActivity {
    TextView aboutTitle;
    TextView aboutDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        aboutTitle = (TextView)findViewById(R.id.about_main_title);
        aboutTitle.setText("Salvo Fitness");
        aboutTitle.setTextSize(30);
        aboutDescription = (TextView)findViewById(R.id.about_main_description);
        aboutDescription.setText("Salvo Fitness is an Android fitness app is aimed for beginners." + "\n\n" + "Salvo Fitness is a simple, easy to use appplication that strives to help users stay fit." + "\n\n" + "Developed By: " +
                "\n Aaron Haslam, \n Jake Johnson, \n Kent Le \n Jesse McCammon.");
        aboutDescription.setTextSize(20);
    }
}

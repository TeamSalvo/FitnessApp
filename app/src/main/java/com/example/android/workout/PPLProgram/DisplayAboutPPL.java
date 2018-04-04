package com.example.android.workout.PPLProgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.workout.R;

public class DisplayAboutPPL extends AppCompatActivity {
    TextView aboutPPLTitle;
    TextView aboutPPLDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about_ppl);

        aboutPPLTitle = (TextView)findViewById(R.id.about_ppl_title);
        aboutPPLTitle.setText("About the PPL Program");

        aboutPPLDescription = (TextView)findViewById(R.id.about_ppl_description);
        aboutPPLDescription.setText("Each workout starts out with a compound lift using a 15 rep goal over 5 sets. If you exceed the rep goal by 0-3 reps then add 2.5-5lbs to the working weight the next time you perform the exercise. If you exceed the rep goal by 4+ reps then add 5-10lbs to the working weight.\n" +
                "\n" +
                "Starting out with a heavy compound lift will is a great way to increase central nervous system (CNS) activity, improve strength, and gain confidence moving heavy loads. When picking a start weight for this lift I would recommend using your 5-6 rep max (RM).\n" +
                "\n" +
                "After the 5 sets of the heavy compound lift you’re going to perform a back-off set in which you decrease the working weight by 20% (round to the nearly 2.5 or 5lbs) and try to perform as many quality reps as possibly (AMQRAP). This set is less taxing on the CNS and allows for some extra volume on the main compound lift of the day, which is helpful for muscle growth and reinforcing proper form. Proportionally increase the working weight of AMQRAP set by 2.5-10lbs every time you increase the weight during the 15 rep goal sets.\n" +
                "\n" +
                "After the main compound movement of the day you’re going to perform rest-pause/bulldozer sets for the remainder of the workout. You will be resting 15 to 60 seconds between each set of an exercise and 2 to 3 minutes between each exercise.\n" +
                "\n" +
                "The accessory work will begin with compound exercises using moderate loads and will conclude will isolation, pump-inducing exercises using relatively low loads. It’s important that you keep track of your timing in between sets – not only to optimize muscle growth but also to prevent you from being in the gym forever. I program my accessory work with high volumes and rest-pause because I believe it’s an effective way to trigger muscle growth in a short period of time while allowing me to leave the gym with a nice pump.\n" +
                "\n" +
                "The exercise selection I lay out in the routine below is by no means set in stone, but I encourage you to be wise if and how you decide to make substitutions. For example, substituting conventional deadlift for sumo deadlift is completely reasonable but substituting chin-ups for another curl exercise is not advisable.  Once you pick your exercises stick with them until you stop progressing; there’s no reason to “confuse” your muscles if you’re adding reps and/or weight to the bar every time you perform an exercise.\n" +
                "\n" +
                "If you’re used to low volume routines this routine will initially make you quite sore – you can either power through the soreness or gradually increase the volume over time. For example, instead of a 50 rep goal over 5 sets with shrugs you could aim for a 30 rep goal over 3 sets the 1st week, 40 reps over 4 sets the 2nd, and 50 reps over 5 sets the 3rd week.");

    }
}

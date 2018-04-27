package com.example.android.workout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.support.v4.media.AudioAttributesCompat.USAGE_ALARM;

public class NotificationUtils extends ContextWrapper {
    private NotificationManager mManager;
    public static final String ANDROID_CHANNEL_ID = "com.android.fitnessalerts.ANDROID";
    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";
    public static final String BASIC_NOTIF = "BASIC_NOTIF";
    public boolean enableNotifications;
    public boolean enableVibrate;
    public boolean enableSound;
    public boolean enableLights;

    public NotificationUtils(Context base){
        super(base);
        createChannels();

        generateSettingsDoc();
        readFile();
    }

    private void createChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID, ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

            androidChannel.enableLights(enableLights);
            androidChannel.enableVibration(enableVibrate);

            AudioAttributes att = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build();

            androidChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, att);
            androidChannel.setLightColor(Color.GREEN);
            androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        }
    }

    private void generateSettingsDoc(){
        try {
            File checkFile = getApplicationContext().getFileStreamPath("salvoSettings.txt");
            if(!checkFile.exists()){
                FileOutputStream file = openFileOutput("salvoSettings.txt",MODE_PRIVATE);
                OutputStreamWriter outputFile = new OutputStreamWriter(file);

                outputFile.write("true\n");
                outputFile.write("true\n");
                outputFile.write("false\n");
                outputFile.write("true\n");

                outputFile.flush();
                outputFile.close();
            }
        } catch (Exception e) {
            Toast.makeText(NotificationUtils.this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void readFile(){

        File file = getApplicationContext().getFileStreamPath("salvoSettings.txt");
        String lineFromFile;

        if(file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("salvoSettings.txt")));
                lineFromFile = reader.readLine();
                enableNotifications = Boolean.parseBoolean(lineFromFile);
                lineFromFile = reader.readLine();
                enableVibrate = Boolean.parseBoolean(lineFromFile);
                lineFromFile = reader.readLine();
                enableSound = Boolean.parseBoolean(lineFromFile);
                lineFromFile = reader.readLine();
                enableLights = Boolean.parseBoolean(lineFromFile);

            }catch (Exception e){
                Toast.makeText(NotificationUtils.this, e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void saveFile(){
        try {
            FileOutputStream file = openFileOutput("salvoSettings.txt",MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            outputFile.write(enableNotifications + "\n");
            outputFile.write(enableVibrate + "\n");
            outputFile.write(enableSound + "\n");
            outputFile.write(enableLights + "\n");


            outputFile.flush();
            outputFile.close();

            Toast.makeText(NotificationUtils.this, "Saved",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(NotificationUtils.this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }



        return mManager;
    }

    public void updateVibrate(boolean set){
        enableVibrate = set;

        saveFile();
    }

    public void updateSound(boolean set){
        enableSound = set;

        saveFile();
    }

    public void updateEnable(boolean set){
        enableNotifications = set;

        saveFile();
    }

    public void launchNotification() {
        readFile();

        Intent notifyIntent = new Intent(this, DisplaySettings.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, ANDROID_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Fitness Woo!")
                .setContentText("This is a test notification hooray!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(notifyPendingIntent)
                .setAutoCancel(true);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if(enableSound) {
            mBuilder.setSound(alarmSound);
        }

        if(enableVibrate) {
            mBuilder.setVibrate(new long[] { 100, 100});
        }

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        int notificationId = 0;

        /*
        Notification note = mBuilder.build();
        if(enableVibrate) {
            note.defaults |= Notification.DEFAULT_VIBRATE;
        }
        if(enableSound) {
            note.defaults |= Notification.DEFAULT_SOUND;

        }*/
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationId, mBuilder.build());

    }

    public void launchLargeNotification() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, ANDROID_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Fitness large!")
                .setContentText("This is a large notification.  Expand me!")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac augue in neque ornare tristique a nec velit. Donec imperdiet nisi lorem, sed pulvinar nisl consectetur eget. Integer ultrices eleifend ornare. Phasellus porttitor faucibus mi vel dictum. Vivamus nec augue odio. Morbi ornare magna vel mollis faucibus. Duis luctus rutrum diam, sed egestas ante scelerisque at. Donec velit nibh, laoreet sit amet leo egestas, placerat venenatis orci. Duis id ex sit amet metus elementum ultrices ac sit amet enim. In eu bibendum est. Nam quis laoreet est, sit amet consequat nisl. Sed metus nunc, malesuada a odio nec, mattis fringilla ante."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        int notificationId = 1;

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationId, mBuilder.build());

    }


}

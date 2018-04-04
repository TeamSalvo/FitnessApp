package com.example.android.workout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class NotificationUtils extends ContextWrapper {
    private NotificationManager mManager;
    public static final String ANDROID_CHANNEL_ID = "com.android.fitnessalerts.ANDROID";
    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";
    public static final String BASIC_NOTIF = "BASIC_NOTIF";

    public NotificationUtils(Context base){
        super(base);
        createChannels();
    }

    private void createChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID, ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

            androidChannel.enableLights(true);
            androidChannel.enableVibration(true);
            androidChannel.setLightColor(Color.GREEN);
            androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        }
    }

    private NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }



        return mManager;
    }

    public void launchNotification() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, ANDROID_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Fitness Woo!")
                .setContentText("This is a notification.  It worked!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        int notificationId = 0;

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

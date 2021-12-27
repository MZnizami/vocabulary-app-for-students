package com.example.itc335;


import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class studentAlert extends Application {
    public static final String channel_one="channel one";
    public static final String channel_two="channel two";
    public static final String channel_three="channel three";
    public static final String channel_four="channel four";
    public static final String channel_five="channel five";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }
    private  void  createNotificationChannels(){
        //check api version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1= new NotificationChannel(
                    channel_one,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("this is channel one");
            NotificationChannel channel2= new NotificationChannel(
                    channel_two,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("this is channel two");

            NotificationChannel channel3= new NotificationChannel(
                    channel_three,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("this is channel three");

            NotificationChannel channel4= new NotificationChannel(
                    channel_four,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel4.setDescription("this is channel four");

            NotificationChannel channel5= new NotificationChannel(
                    channel_five,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel5.setDescription("this is channel five");

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);



        }
    }
}

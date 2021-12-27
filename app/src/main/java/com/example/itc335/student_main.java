package com.example.itc335;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;


import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.itc335.studentAlert.channel_five;
import static com.example.itc335.studentAlert.channel_four;
import static com.example.itc335.studentAlert.channel_one;
import static com.example.itc335.studentAlert.channel_three;
import static com.example.itc335.studentAlert.channel_two;


public class student_main extends Fragment {

CardView box1,box2,box3,box4,box5;
TextView studentName,boxNumber1,boxNumber2,boxNumber3,boxNumber4,boxNumber5;
Cursor boxNo1;
String currentDate;
NotificationManagerCompat notificationManager;
Calendar c_box2,c_box3,c_box4,c_box5;
    String nameStudent, lastName;

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.student_main,container,false);

        vocabDatabase dbDatabase= new vocabDatabase(getActivity());

        notificationManager=NotificationManagerCompat.from(getActivity());

        box1= view.findViewById(R.id.box1);
        box2= view.findViewById(R.id.box2);
        box3= view.findViewById(R.id.box3);
        box4= view.findViewById(R.id.box4);
        box5= view.findViewById(R.id.box5);
        studentName= view.findViewById(R.id.studentNam);

        boxNumber1= view.findViewById(R.id.boxOne);
        boxNumber2= view.findViewById(R.id.boxNum2);
        boxNumber3= view.findViewById(R.id.boxNum3);
        boxNumber4= view.findViewById(R.id.boxNum4);
        boxNumber5= view.findViewById(R.id.boxNum5);
        nameStudent=getArguments().getString("name");
        lastName=getArguments().getString("lastname");
        studentName.setText(nameStudent+" "+lastName);
        String name=studentName.getText().toString();
        send1();
//get the date of box1 from the score table so we could disable and enable the box's button based on the date of box1
        boxNo1 = dbDatabase.getRecordOfScore(name,boxNumber1.getText().toString());
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());




    //display the date for the box to the student
        if(boxNo1.moveToFirst()){
            do{
                String getDate= boxNo1.getString(5);
                String getDate3= boxNo1.getString(5);
                String getDate4= boxNo1.getString(5);
                String getDate5= boxNo1.getString(5);

                System.out.println("0000000000000000000000000000000000000000000000000000"+getDate);

                // Start date
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                c_box2 = Calendar.getInstance();
                c_box3 = Calendar.getInstance();
                c_box4 = Calendar.getInstance();
                c_box5 = Calendar.getInstance();
                try {
                    c_box2.setTime(sdf.parse(getDate));
                    c_box3.setTime(sdf.parse(getDate));
                    c_box4.setTime(sdf.parse(getDate));
                    c_box5.setTime(sdf.parse(getDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c_box2.add(Calendar.DATE, 3);  // number of days to add for the box2 to which is 3 days after box1
                c_box3.add(Calendar.DATE, 6);  // number of days to add for the box3 to which is one week after box1
                c_box4.add(Calendar.DATE, 13);  // number of days to add for the box4 to which is two weeks after box1
                c_box5.add(Calendar.DATE, 29);  // number of days to add for the box5 to which is 29 days after box1
                getDate = sdf.format(c_box2.getTime());
                getDate3 = sdf.format(c_box3.getTime());
                getDate4 = sdf.format(c_box4.getTime());
                getDate5 = sdf.format(c_box5.getTime());


//////////////////////////////////this condition will apply for box2///////////////////////////////////////////
                if (getDate.equals(currentDate)){
                    System.out.println("0000000000000000000000000000000000000000000000000000"+currentDate+" Current Date");
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate+" it will enable");
                    box2.setEnabled(true);
                    send2();

                }
                else{
                    System.out.println("****************************8"+"not true **********************************");
                    box2.setEnabled(false);
                    Toast.makeText(getActivity(),"The box2 is not available \n come back after two days!",Toast.LENGTH_LONG);
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate+"it will enable");
                }
                //////////////////////////////////this condition will apply for box3///////////////////////////////////////////
                if (getDate3.equals(currentDate)){
                    System.out.println("0000000000000000000000000000000000000000000000000000"+currentDate+" Current Date");
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate3+" it will enable");
                    box3.setEnabled(true);
                    send3();

                }
                else{
                    System.out.println("*****************************"+"not true \n box3 will be unable **********************************");
                    box3.setEnabled(false);
                    Toast.makeText(getActivity(),"The box3 is not available \n come back after six days!",Toast.LENGTH_LONG);
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate3+" it will enable");
                }
                //////////////////////////////////this condition will apply for box4///////////////////////////////////////////
                if (getDate4.equals(currentDate)){
                    System.out.println("0000000000000000000000000000000000000000000000000000"+currentDate+" Current Date");
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate4+" it will enable");
                    box4.setEnabled(true);
                    send4();

                }
                else{
                    System.out.println("*****************************"+"not true \n box4 will be unable **********************************");
                    box4.setEnabled(false);
                    Toast.makeText(getActivity(),"The box4 is not available \n come back after 16 days!",Toast.LENGTH_LONG);
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate4+" it will enable");
                }
                //////////////////////////////////this condition will apply for box5///////////////////////////////////////////
                if (getDate5.equals(currentDate)){
                    System.out.println("0000000000000000000000000000000000000000000000000000"+currentDate+" Current Date");
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate5+" it will enable");
                    box5.setEnabled(true);
                    send5();

                }
                else{
                    System.out.println("*****************************"+"not true \n box5 will be unable **********************************");
                    box5.setEnabled(false);
                    Toast.makeText(getActivity(),"The box5 is not available \n come back after 29 days!",Toast.LENGTH_LONG);
                    System.out.println("0000000000000000000000000000000000000000000000000000"+getDate5+" it will enable");
                }

            }while(boxNo1.moveToNext());

        }

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=studentName.getText().toString();
                String boxnum=boxNumber1.getText().toString();
                Intent intent = new Intent(getActivity(), box1.class);
                intent.putExtra("studentN",name);
                intent.putExtra("boxON",boxnum);
                startActivity(intent);
            }
        });

        //for the cardView of box2

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=studentName.getText().toString();
                String boxnum=boxNumber2.getText().toString();
                Intent intent = new Intent(getActivity(), student_box2.class);
                intent.putExtra("studentN",name);
                intent.putExtra("boxON",boxnum);
                startActivity(intent);
            }
        });

        //for the cardView of box3

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=studentName.getText().toString();
                String boxnum=boxNumber3.getText().toString();
                Intent intent = new Intent(getActivity(), student_box3.class);
                intent.putExtra("studentN",name);
                intent.putExtra("boxON",boxnum);
                startActivity(intent);
            }
        });
        //for the cardView of box4

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=studentName.getText().toString();
                String boxnum=boxNumber4.getText().toString();
                Intent intent = new Intent(getActivity(), student_box4.class);
                intent.putExtra("studentN",name);
                intent.putExtra("boxON",boxnum);
                startActivity(intent);
            }
        });

        //for the cardView of box5

        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=studentName.getText().toString();
                String boxnum=boxNumber5.getText().toString();
                Intent intent = new Intent(getActivity(), student_box5.class);
                intent.putExtra("studentN",name);
                intent.putExtra("boxON",boxnum);
                startActivity(intent);
            }
        });
        return view;

    }
    public void send1() {
        String title1= "View Box1";
        String message1="The vocabularies are available ";
        Notification notification= new NotificationCompat.Builder(getActivity(),channel_one)
                .setSmallIcon(R.drawable.b1)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,notification);
    }

    public void send2() {
        String title1= "View Box2";
        String message1="The vocabularies are NOW available ";
        Notification notification= new NotificationCompat.Builder(getActivity(),channel_two)
                .setSmallIcon(R.drawable.b2)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(2,notification);
    }
//box3
public void send3() {
    String title1= "View Box3";
    String message1="The vocabularies are Now available ";
    Notification notification= new NotificationCompat.Builder(getActivity(),channel_three)
            .setSmallIcon(R.drawable.b3)
            .setContentTitle(title1)
            .setContentText(message1)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build();
    notificationManager.notify(3,notification);
}

    public void send4() {
        String title1= "View Box4";
        String message1="The vocabularies are available ";
        Notification notification= new NotificationCompat.Builder(getActivity(),channel_four)
                .setSmallIcon(R.drawable.b4)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(4,notification);
    }

    public void send5() {
        String title1= "View Box5";
        String message1="The vocabularies are now available ";
        Notification notification= new NotificationCompat.Builder(getActivity(),channel_five)
                .setSmallIcon(R.drawable.b5)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(5,notification);
    }
}
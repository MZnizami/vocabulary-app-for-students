package com.example.itc335;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;



import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Currency;
import java.util.List;

public class student_progress extends Fragment {

    TextView name,box1,box2,box3,box4,box5;
    TextView boxT1,boxT2,boxT3,boxT4,boxT5;
    ProgressBar pBox1,pBox2,pBox3,pBox4,pBox5;
    Cursor boxNo1,boxNo2,boxNo3,boxNo4,boxNo5;
    String StudentName,nameStudent,lastName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.student_progress,container,false);
        name=view.findViewById(R.id.progressName);

        box1= view.findViewById(R.id.box1Progress);
        box2= view.findViewById(R.id.box2Progress);
        box3= view.findViewById(R.id.box3Progress);
        box4= view.findViewById(R.id.box4Progress);
        box5= view.findViewById(R.id.box5Progress);

        boxT1= view.findViewById(R.id.box1_percent);
        boxT2= view.findViewById(R.id.box2_percent);
        boxT3= view.findViewById(R.id.box3_percent);
        boxT4= view.findViewById(R.id.box4_percent);
        boxT5= view.findViewById(R.id.box5_percent);

        pBox1= view.findViewById(R.id.progress_box1);
        pBox2= view.findViewById(R.id.progress_box2);
        pBox3= view.findViewById(R.id.progress_box3);
        pBox4= view.findViewById(R.id.progress_box4);
        pBox5= view.findViewById(R.id.progress_box5);

        //////////////////////////////////////////////////////////////////////////////



        System.out.println("this is the progress bar" +"//////////////////////////////////////////////////////////////////////////////");

        System.out.println(name.getText().toString()+")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
        System.out.println("this is the progress bar" +"//////////////////////////////////////////////////////////////////////////////");
        nameStudent=getArguments().getString("name");
        lastName=getArguments().getString("lastname");
        name.setText(nameStudent+" "+lastName);
        StudentName=name.getText().toString();


        ////////////////////////////////////////////////////////////////////////////
        vocabDatabase dbDatabase= new vocabDatabase(getActivity());


        String getBox1=box1.getText().toString();
        String getBox2=box2.getText().toString();
        String getBox3=box3.getText().toString();
        String getBox4=box4.getText().toString();
        String getBox5=box5.getText().toString();

        boxNo1 = dbDatabase.getRecordOfScore(StudentName,getBox1);
        boxNo2 = dbDatabase.getRecordOfScore(StudentName,getBox2);
        boxNo3 = dbDatabase.getRecordOfScore(StudentName,getBox3);
        boxNo4 = dbDatabase.getRecordOfScore(StudentName,getBox4);
        boxNo5 = dbDatabase.getRecordOfScore(StudentName,getBox5);


//display the score for the box to the student
        if(boxNo1.moveToFirst()){
            do{
                pBox1.setMax(Integer.parseInt(boxNo1.getString(2)));
                pBox1.setProgress(Integer.parseInt(boxNo1.getString(4)));
                boxT1.setText(boxNo1.getString(4)+"%");


            }while(boxNo1.moveToNext());

        }
//display the score for the box2 to the student
        if(boxNo2.moveToFirst()){
            do{
                pBox2.setMax(Integer.parseInt(boxNo2.getString(2)));
                pBox2.setProgress(Integer.parseInt(boxNo2.getString(4)));
                boxT2.setText(boxNo2.getString(4)+"%");


            }while(boxNo2.moveToNext());

        }

//display the score for the box3 to the student
        if(boxNo3.moveToFirst()){
            do{
                pBox3.setMax(Integer.parseInt(boxNo3.getString(2)));
                pBox3.setProgress(Integer.parseInt(boxNo3.getString(4)));
                boxT3.setText(boxNo3.getString(4)+"%");


            }while(boxNo3.moveToNext());

        }

//display the score for the box4 to the student
        if(boxNo4.moveToFirst()){
            do{
                pBox4.setMax(Integer.parseInt(boxNo4.getString(2)));
                pBox4.setProgress(Integer.parseInt(boxNo4.getString(4)));
                boxT4.setText(boxNo4.getString(4)+"%");


            }while(boxNo4.moveToNext());

        }

//display the score for the box5 to the student
        if(boxNo5.moveToFirst()){
            do{
                pBox5.setMax(Integer.parseInt(boxNo5.getString(2)));
                pBox5.setProgress(Integer.parseInt(boxNo5.getString(4)));
                boxT5.setText(boxNo5.getString(4)+"%");


            }while(boxNo5.moveToNext());

        }





        return view;
    }

}
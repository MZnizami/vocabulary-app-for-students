package com.example.itc335;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class student_firstPage extends AppCompatActivity{
    BottomNavigationView action;
    student_main studentMain;
    student_progress student_progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_first_page);
        action=findViewById(R.id.navbar);
        Intent inent=getIntent();
        String studentName=inent.getStringExtra("name");
        String studentLast=inent.getStringExtra("lastname");

        System.out.println("ehshkfsdj%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+studentName+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("ehshkfsdj%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+studentLast+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        studentMain= new student_main();
        Bundle args = new Bundle();
        args.putString("name", studentName);
        args.putString("lastname", studentLast);
        studentMain.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,studentMain).commit();

        action.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment choosen=null;
                if (item.getItemId()==R.id.profile){
                    choosen=new student_profile();
                    Bundle args = new Bundle();
                    args.putString("name", studentName);
                    args.putString("lastname", studentLast);
                    choosen.setArguments(args);
                }
                else if (item.getItemId()==R.id.home){
                    choosen=new student_main();
                    Bundle args = new Bundle();
                    args.putString("name", studentName);
                    args.putString("lastname", studentLast);
                    choosen.setArguments(args);

                }
                else if (item.getItemId()==R.id.progress){
                    choosen=new student_progress();
                    Bundle args = new Bundle();
                    args.putString("name", studentName);
                    args.putString("lastname", studentLast);
                    choosen.setArguments(args);
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,choosen).commit();
                return true;
            }
        });
    }


}
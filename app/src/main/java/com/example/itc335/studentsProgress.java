package com.example.itc335;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class studentsProgress extends AppCompatActivity {
        BottomNavigationView action;
         Box1Fragment Box1Fragment;
        Box2Fragment Box2Fragment;
         Box3Fragment Box3Fragment;
        Box4Fragment Box4Fragment;
        Box5Fragment Box5Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_progress);

        action=findViewById(R.id.navbarInstructor);

        Intent intent= getIntent();

        Box1Fragment = new Box1Fragment();
        Box2Fragment = new Box2Fragment();
        Box3Fragment = new Box3Fragment();
        Box4Fragment = new Box4Fragment();
        Box5Fragment = new Box5Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,Box1Fragment).commit();
        action.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment choosen=null;
                if (item.getItemId()==R.id.box1){
                    choosen=Box1Fragment;
                }
                else if (item.getItemId()==R.id.box2){
                    choosen= Box2Fragment;

                }
                else if (item.getItemId()==R.id.box3){
                    choosen=Box3Fragment;

                }
                else if (item.getItemId()==R.id.box4){
                    choosen= Box4Fragment;

                }
                else if (item.getItemId()==R.id.box5){
                    choosen= Box5Fragment;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,choosen).commit();
                return true;
            }
        });
    }


        }




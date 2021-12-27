package com.example.itc335;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class instructor_mainPage extends AppCompatActivity {

   // DatabaseHelper mydb;
    private ImageView progressButton;
    private ImageView profile, box1Vocabulary,report;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_mainpage);
        name=findViewById(R.id.InstructorName);
  Intent intent=getIntent();
        String studentName=intent.getStringExtra("name");
        String studentLast=intent.getStringExtra("lastname");
        name.setText(studentName+" "+studentLast);
        System.out.println("ehshkfsdj%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+studentName+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("ehshkfsdj%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+studentLast+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        progress bar
        progressButton =  findViewById(R.id.progressButton);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(instructor_mainPage.this, studentsprogress_instructor.class);
                startActivity(intent);
            }
        });

        //        profile
        profile =  findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(instructor_mainPage.this, student_profile.class);
                startActivity(intent);
            }
        });

//        box1 words view list
        box1Vocabulary = findViewById(R.id.box1Vocabulary);
        box1Vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(instructor_mainPage.this, vocabularyDetailActivity.class);
                startActivity(intent);
            }
        });
report=findViewById(R.id.reportButton);
report.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(instructor_mainPage.this, insertVocabulary.class);
        startActivity(intent);
    }
});

    }









}
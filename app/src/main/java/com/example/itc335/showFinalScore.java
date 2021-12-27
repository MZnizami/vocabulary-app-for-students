package com.example.itc335;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class showFinalScore extends AppCompatActivity {
    TextView bxNum,sName,questionNum, finalScore,date;
    Button done;
    vocabDatabase myDb;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_final_score);
        myDb = new vocabDatabase(this);

        bxNum=findViewById(R.id.b1);
        sName=findViewById(R.id.sName1);
        questionNum=findViewById(R.id.questionNum);
        finalScore=findViewById(R.id.finalScore);
        date=findViewById(R.id.date);
        done=findViewById(R.id.confirm_button);

        Bundle extras = getIntent().getExtras();
       String student_name = extras.getString("studentName");
       String box_one = extras.getString("box1");
       String todayDate = extras.getString("date");
        int question = extras.getInt("questionNum",0);
        int score = extras.getInt("score",0);
        sName.setText(student_name);
        date.setText(todayDate);
        bxNum.setText(box_one);
        questionNum.setText(Integer.toString(question));
        finalScore.setText(Integer.toString(score));


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String box = bxNum.getText().toString();
               String s_name = sName.getText().toString();
               String questionN = questionNum.getText().toString();
               String score = finalScore.getText().toString();
               String getDateNumber=date.getText().toString();
               boolean checkStudent = myDb.check(s_name,box,score,getDateNumber);
                if (checkStudent==true) {
                    Toast.makeText(showFinalScore.this, "Student Score has been updated", Toast.LENGTH_SHORT).show();
                     }
                else {
                    boolean isInserted = myDb.insertData(box,questionN,s_name,score,getDateNumber);
                    if (isInserted==true) {
                        Toast.makeText(showFinalScore.this, "Data added", Toast.LENGTH_LONG).show();
                       finish();
                         }
                    else{ Toast.makeText(showFinalScore.this, "There is a problem\n try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
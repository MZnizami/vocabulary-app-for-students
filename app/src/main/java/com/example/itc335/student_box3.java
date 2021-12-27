package com.example.itc335;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class student_box3 extends AppCompatActivity {
    private TextView wordQuestion, questionCount,testScore, name,boxNumber;
    private RadioGroup rbGroup;
    private RadioButton choice1,choice2,rbButton;
    private Button confirmBtn,close;
    private List<vocabulary> wordList;
    private ProgressBar progress;
    private int questionCounter;
    private int questionCountTotal;
    private vocabulary currentQuestion;
    private int score;
    private int point=0;
    String date;
    private boolean answered;
    private ColorStateList textColorDefaultRb;
    int progressValue=0;
    private String student_name,box_one;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_box3);

        name=findViewById(R.id.studentNamebox1);
        boxNumber=findViewById(R.id.box1);

        wordQuestion=findViewById(R.id.wordQuestion);
        questionCount=findViewById(R.id.questionCount);
        testScore=findViewById(R.id.testScore);
        rbGroup=findViewById(R.id.radio_group);
        choice1=findViewById(R.id.choice1);
        choice2=findViewById(R.id.choice2);
        progress=findViewById(R.id.progress);
        confirmBtn=findViewById(R.id.confirm_button);
        close=findViewById(R.id.close);

        student_name = getIntent().getStringExtra("studentN");
        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        box_one = getIntent().getStringExtra("boxON");
        name.setText(student_name);
        boxNumber.setText(box_one);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        vocabDatabase dbDatabase= new vocabDatabase(this);
        //this will get all records which is in box1
        wordList = dbDatabase.getRecord3(student_name);
        questionCountTotal = wordList.size();

        Collections.shuffle(wordList);

        showNextQuestion();
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (choice1.isChecked() || choice2.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(student_box3.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String word= wordQuestion.getText().toString();
                    String rightMeaning= choice1.getText().toString();
                    String wrongMeaning=choice2.getText().toString();
                    if (choice1.isChecked()){
                        int point1=3;
                        boolean isInserted2 = dbDatabase.insertDataIntoBox4(student_name,word,rightMeaning,wrongMeaning,point1);
                        if (isInserted2) {
                            Toast.makeText(student_box3.this, "Data added to box4", Toast.LENGTH_SHORT).show();
                        }
                        else{ Toast.makeText(student_box3.this, "There is a problem\n try again", Toast.LENGTH_SHORT).show();
                        }

                        ////////////////////////////////////////////////////////////deletion ////////////////////////////////////
                        Integer isDeleted = dbDatabase.deleteFromBox3(student_name,word);
                        if (isDeleted > 0) {
                            Toast.makeText(student_box3.this, "word has been deleted from box3", Toast.LENGTH_SHORT).show();
                        }
                        else{ Toast.makeText(student_box3.this, "There is a problem\n try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    showNextQuestion();
                }
            }

        });
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void showNextQuestion(){
        choice1.setBackground(getResources().getDrawable(R.drawable.round));
        choice2.setBackground(getResources().getDrawable(R.drawable.round));
        rbGroup.clearCheck();


        if (questionCounter < questionCountTotal && progressValue < questionCountTotal) {
            progress.setMax(questionCountTotal);
            currentQuestion = wordList.get(questionCounter);
            wordQuestion.setText(currentQuestion.getWord());
            String word= wordQuestion.getText().toString();
            choice1.setText(currentQuestion.getOption1());
            String rightMeaning= choice1.getText().toString();
            choice2.setText(currentQuestion.getOption2());
            String wrongMeaning=choice2.getText().toString();


            questionCounter++;
            progressValue=questionCounter;

            progress.setProgress(progressValue);
            questionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;

            confirmBtn.setText("Confirm");





        } else {
            finishQuiz();
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void checkAnswer(){
        answered = true;

        // get selected radio button from radioGroup
        int selectedId = rbGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rbButton = (RadioButton) findViewById(selectedId);

        if (rbButton.getText().toString() == currentQuestion.getOption1()) {
            score++;
            testScore.setText("Score: " + score);
        }
        showSolution();
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void showSolution(){
        choice1.setBackground(getResources().getDrawable(R.drawable.background_red));
        choice2.setBackground(getResources().getDrawable(R.drawable.background_red));
        // get selected radio button from radioGroup
        int selectedId = rbGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rbButton = (RadioButton) findViewById(selectedId);
        if (rbButton.getText().toString() == currentQuestion.getOption1()) {
            choice1.setBackground(getResources().getDrawable(R.drawable.backgroun_green));
        }
        else {
            choice2.setBackground(getResources().getDrawable(R.drawable.backgroun_green));
        }


        if (questionCounter < questionCountTotal) {
            confirmBtn.setText("Next");
        } else {
            confirmBtn.setText("Finish");
        }
    }
    private void finishQuiz() {
        if (questionCountTotal==0){
            Toast.makeText(student_box3.this, "There are no Questions in this box", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
        Intent i = new Intent(student_box3.this, showFinalScore.class);
        i.putExtra("studentName",student_name);
        i.putExtra("box1",box_one);
        i.putExtra("date",date);
        i.putExtra("questionNum",questionCountTotal);
        i.putExtra("score",score);
        startActivity(i);}

    }
}
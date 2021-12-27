package com.example.itc335;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.Date;

import static com.example.itc335.R.string.invalid_CorrectMeaning;
import static com.example.itc335.R.string.invalid_WrongMeaning;
import static com.example.itc335.R.string.invalid_name;

public class vocabularyDetailActivity extends AppCompatActivity {



    private EditText wordEditText, correctMeaningET, wrongMeaningET;
    private Button saveButton;
    private vocabDatabase mydb;
    AwesomeValidation awesomeValidation;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_detail);
        wordEditText = findViewById(R.id.wordEditText);
        correctMeaningET = findViewById(R.id.correctMeaningET);
        wrongMeaningET = findViewById(R.id.wrongMeaningET);

        saveButton = findViewById(R.id.savebtn);
        Intent getIntent= getIntent();
        //initalize style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //word validation
        awesomeValidation.addValidation(this, R.id.wordEditText,
                RegexTemplate.NOT_EMPTY, invalid_name);

        awesomeValidation.addValidation(this, R.id.correctMeaningET,
                RegexTemplate.NOT_EMPTY, invalid_CorrectMeaning);

        awesomeValidation.addValidation(this, R.id.wrongMeaningET,
                RegexTemplate.NOT_EMPTY, invalid_WrongMeaning);
        mydb=new vocabDatabase(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = String.valueOf(wordEditText.getText());
                String wrongMeaning = String.valueOf(wrongMeaningET.getText());
                String correctMeaning = String.valueOf(correctMeaningET.getText());
               check= mydb.getRecordOfInstructorWord(word);

                if(check==true){

                    Toast.makeText(vocabularyDetailActivity.this,
                            "the word is already in database \n please enter another word", Toast.LENGTH_SHORT).show();
                    wordEditText.getText().clear();
                    wrongMeaningET.getText().clear();
                    correctMeaningET.getText().clear();
                }
                else {

                    if (awesomeValidation.validate()) {
                        boolean isInserted = mydb.insertIntoInstructorTable(word,correctMeaning,wrongMeaning);

                        if (isInserted) {
                            Toast.makeText(vocabularyDetailActivity.this, "Data added to box2", Toast.LENGTH_SHORT).show();
                            wordEditText.getText().clear();
                            wrongMeaningET.getText().clear();
                            correctMeaningET.getText().clear();
                        }
                        else{ Toast.makeText(vocabularyDetailActivity.this, "There is a problem\n try again", Toast.LENGTH_SHORT).show();
                        }





                    } else {
                        //on success
                        Toast.makeText(getApplicationContext(),
                                "validation failed...", Toast.LENGTH_SHORT).show();

                }


            }
        }});




    }








}
package com.example.itc335;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//main words page
public class insertVocabulary extends AppCompatActivity {

    RecyclerView vocabularyView;
    vocabDatabase mydb;
    Button addNewWord;
    ArrayList<String> id, word, meaning;
    instructor_see_word see_wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vocabulary);
        addNewWord=findViewById(R.id.newWord);
        Intent getIntent= getIntent();
        mydb=new vocabDatabase(this);


        vocabularyView=findViewById(R.id.vocabularyListView);
        id = new ArrayList<>();
        word = new ArrayList<>();
        meaning = new ArrayList<>();
      see_wordAdapter=new instructor_see_word(insertVocabulary.this,id,word,meaning);
      vocabularyView.setAdapter(see_wordAdapter);
      vocabularyView.setLayoutManager(new LinearLayoutManager(insertVocabulary.this));
        displayWord1();
        addNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }


    public void  displayWord1() {
        Cursor cursor = mydb.readAllDatainstructor();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "not data found", Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                word.add(cursor.getString(1));
                meaning.add(cursor.getString(2));
            }
        }
    }


}
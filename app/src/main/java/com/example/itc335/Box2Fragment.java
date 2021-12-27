package com.example.itc335;//package com.example.studentlearningapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Box2Fragment extends Fragment {

    RecyclerView recyclerView;

    getRecordBox1ScoreAdapter adapter;
    ArrayList<String> name,date,score;
    vocabDatabase mydb;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_box2,container,false);
        recyclerView=view.findViewById(R.id.box1RecycleView);
        mydb=new vocabDatabase(getActivity());
        name=new ArrayList<>();
        date=new ArrayList<>();
        score=new ArrayList<>();


        adapter=new getRecordBox1ScoreAdapter(getActivity(),name,date,score);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        displayWord1();

        return view;

    }
    public void  displayWord1() {
        Cursor cursor=mydb.showBoxesScoreToInstructor2();
        if (cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "not data found", Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(3));
                score.add(cursor.getString(4));
                date.add(cursor.getString(5));
            }
        }
    }
}


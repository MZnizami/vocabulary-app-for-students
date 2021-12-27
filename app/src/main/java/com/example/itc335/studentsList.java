package com.example.itc335;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class studentsList extends Fragment {
    vocabDatabase db;
    RecyclerView recyclerView;
    ArrayList<String> fname, lname, uname, email, pass;
    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);
        db = new vocabDatabase(getActivity());
        recyclerView = view.findViewById(R.id.recyclerView);
        fname = new ArrayList<>();
        lname = new ArrayList<>();
        uname = new ArrayList<>();
        email = new ArrayList<>();
        pass = new ArrayList<>();
        viewData();
        Context context = getActivity().getApplicationContext();
        customAdapter = new CustomAdapter(getActivity(), context, fname, lname, uname, email, pass );
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private void viewData() {
        Cursor cursor = db.viewstudents();
        if(cursor.getCount()==0){
            Toast.makeText(getActivity(), "There are no students in the list!", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                fname.add(cursor.getString(1));
                lname.add(cursor.getString(2));
                uname.add(cursor.getString(3));
                email.add(cursor.getString(4));
                pass.add(cursor.getString(5));
           }

        }
    }
}
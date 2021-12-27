package com.example.itc335;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class alter extends Fragment {
    vocabDatabase mydb;
    Button btndelete, btnupdate;
    EditText fnameview, lnameview, unameview, emailview, passview;
    RadioGroup rg1;
    RadioButton rb1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alter, container, false);
        btndelete = view.findViewById(R.id.delete);
        btnupdate = view.findViewById(R.id.Update);
        mydb = new vocabDatabase(getActivity());
        fnameview = view.findViewById(R.id.tfname);
        lnameview = view.findViewById(R.id.tlname);
        unameview = view.findViewById(R.id.tuname);
        emailview = view.findViewById(R.id.temail);
        passview = view.findViewById(R.id.tpass);
        rg1 = view.findViewById(R.id.rg1);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = unameview.getText().toString();
                int selectedId = rg1.getCheckedRadioButtonId();
                String selectedValue;
                // find the radiobutton by returned id
                rb1 =  view.findViewById(selectedId);
                switch (selectedId)
                {
                    case R.id.rstudent:
                        selectedValue = "Student";
                        break;
                    case R.id.rinstructor:
                        selectedValue = "Instructor";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + selectedId);
                }

                if (selectedValue.equals("Student")){
                    Boolean check = mydb.deleteStudent(username);
                    if(check==true){

                        Toast.makeText(getActivity(), "Student Deleted!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity(), "Student username does not exist!", Toast.LENGTH_LONG).show();
                    }

                }
                else if(selectedValue.equals("Instructor")) {
                    Boolean check = mydb.deleteInstructor(username);
                    if(check==true){
                        Toast.makeText(getActivity(), "Instructor deleted!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity(), "Instructor does not exists!", Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(), "Invalid Role", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = unameview.getText().toString();
                String fname = fnameview.getText().toString();
                String lname = lnameview.getText().toString();
                String email = emailview.getText().toString();
                String pass = passview.getText().toString();
                int selectedId = rg1.getCheckedRadioButtonId();
                String selectedValue;
                // find the radiobutton by returned id
                rb1 =  view.findViewById(selectedId);
                switch (selectedId)
                {
                    case R.id.rstudent:
                        selectedValue = "Student";
                        break;
                    case R.id.rinstructor:
                        selectedValue = "Instructor";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + selectedId);
                }

                if (selectedValue.equals("Student")){
                    Boolean check = mydb.updateStudent(fname, lname, username, email, pass);
                    if(check==true){

                        Toast.makeText(getActivity(), "Student Updated!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity(), "Student username does not exist!", Toast.LENGTH_LONG).show();
                    }

                }
                else if(selectedValue.equals("Instructor")) {
                    Boolean check = mydb.updateInstructor(fname, lname, username, email, pass);
                    if(check==true){
                        Toast.makeText(getActivity(), "Instructor updated!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity(), "Instructor does not exists!", Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(), "Invalid Role", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

}
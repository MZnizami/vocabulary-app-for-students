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


public class Add extends Fragment {

    vocabDatabase mydb;
    Button btnregister;
    EditText fnameview, lnameview, unameview, emailview, passview;
    RadioGroup rg1;
    RadioButton rb1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
         mydb = new vocabDatabase(getActivity());
        btnregister = view.findViewById(R.id.register);
        fnameview = view.findViewById(R.id.tfname);
        lnameview = view.findViewById(R.id.tlname);
        unameview = view.findViewById(R.id.tuname);
        emailview = view.findViewById(R.id.temail);
        passview = view.findViewById(R.id.tpass);
        rg1 = view.findViewById(R.id.rg1);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = fnameview.getText().toString();
                String lname = lnameview.getText().toString();
                String uname = unameview.getText().toString();
                String email = emailview.getText().toString();
                String password = passview.getText().toString();

                if (fname.equals("")||lname.equals("")||uname.equals("")||email.equals("")||password.equals("")){
                    Toast.makeText(getActivity(),"Please insert all the values!",Toast.LENGTH_LONG).show();
                }

                else {
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
                        Boolean checkuser = mydb.checkStudentName(uname);
                        if(checkuser==false){
                            Boolean ISinserted = mydb.insertStudentData(fname, lname, uname, email, password);
                            if(ISinserted==true){
                                Toast.makeText(getActivity(), "Student Registered successfully", Toast.LENGTH_LONG).show();

                            }else{
                                Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "Student already exists!", Toast.LENGTH_LONG).show();
                        }

                    }
                    else if(selectedValue.equals("Instructor")) {
                        Boolean checkuser = mydb.checkInstructorName(uname);
                        if(checkuser==false){
                            Boolean ISinserted = mydb.insertInstructorData(fname, lname, uname, email, password);
                            if(ISinserted==true){
                                Toast.makeText(getActivity(), "Instructor Registered successfully", Toast.LENGTH_LONG).show();

                            }else{
                                Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(getActivity(), "Instructor already exists!", Toast.LENGTH_LONG).show();
                        }

                    }
                    else{
                        Toast.makeText(getActivity(), "Invalid Role", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });


        return view;

    }
}
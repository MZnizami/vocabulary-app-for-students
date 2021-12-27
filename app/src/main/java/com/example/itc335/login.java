package com.example.itc335;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    vocabDatabase mydb;
    EditText unameview, passview;
    Button btnlogin;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mydb = new vocabDatabase(this);

        unameview = findViewById(R.id.tusername);
        passview = findViewById(R.id.tpassword);
        btnlogin = findViewById(R.id.login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = unameview.getText().toString();
                String pass = passview.getText().toString();

                if (username.equals("")||pass.equals("")){
                    Toast.makeText(login.this,"Please insert all the values!",Toast.LENGTH_LONG).show();
                }
                else if(username.equalsIgnoreCase("admin")&&pass.equalsIgnoreCase("admin")){
                    Intent intent = new Intent(login.this,Admin_Dashboard.class);
                    startActivity(intent);

                }
                else {
                    boolean isTrue =mydb.checkCredentialsStudent(username,pass);
                    boolean exists =mydb.checkCredentialsInstructor(username,pass);
                    if (isTrue==true){
                        cursor=mydb.getRecordOfStudentList(username);

                        if(cursor.moveToFirst()) {
                            do {
                                String name= cursor.getString(1);
                                String lastname= cursor.getString(2);

                                System.out.println(name+"////////////////////////////////////////////////"+lastname);
                                Intent intent = new Intent(login.this,student_firstPage.class);
                                intent.putExtra("name",name);
                                intent.putExtra("lastname",lastname);
                                startActivity(intent);
                            }while(cursor.moveToNext());
                        }

                        Toast.makeText(com.example.itc335.login.this,"You Signed In Successfully",Toast.LENGTH_LONG).show();
                    }
                    else if(exists==true){
                        cursor=mydb.getRecordOfInstructorList(username);
                        if(cursor.moveToFirst()) {
                            do {
                                String name= cursor.getString(1);
                                String lastname= cursor.getString(2);

                                System.out.println(name+"////////////////////////////////////////////////"+lastname);
                                Intent intent = new Intent(login.this,instructor_mainPage.class);
                                intent.putExtra("name",name);
                                intent.putExtra("lastname",lastname);
                                startActivity(intent);
                            }while(cursor.moveToNext());
                        }

                        Toast.makeText(com.example.itc335.login.this,"You Signed In Successfully",Toast.LENGTH_LONG).show();
                    }

                    else {
                        Toast.makeText(com.example.itc335.login.this,"Incorrect Username or Password!",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });


    }
}
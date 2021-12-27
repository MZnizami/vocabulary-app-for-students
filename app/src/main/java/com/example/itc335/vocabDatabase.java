package com.example.itc335;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.itc335.vocabularyContract.*;

import java.util.ArrayList;
import java.util.List;

public class vocabDatabase extends SQLiteOpenHelper {
    private static final String database_name="OurAwesomeVocabulary.db";
//admin tables
public static  final String TableName = "student";
    public static  final String TableName2 = "instructor";
    public static final String col1student = "firstname";
    public static final String col2student = "lastname";
    public static final String col3student = "username";
    public static final String col4student = "email";
    public static final String col5student = "password";
    public static final String col1instructor = "firstname";
    public static final String col2instructor= "lastname";
    public static final String col3instructor = "username";
    public static final String col4instructor = "email";
    public static final String col5instructor = "password";


    //create table for the student_box1
    public static final String Student_box1="Student_box1";
    public static final String Student_name="Student_name";
    public static final String word="word";
    public static final String meaning="meaning";
    public static final String wrongMeaning="wrongMeaning";
    public static final String point="point";

    //create table for the student_box2
    public static final String Student_box2="Student_box2";
    public static final String Student_name0="Student_name";
    public static final String word0="word";
    public static final String meaning0="meaning";
    public static final String wrongMeaning0="wrongMeaning";
    public static final String point0="point";

    //create table for the student_box3
    public static final String Student_box3="Student_box3";
    public static final String Student_name1="Student_name";
    public static final String word1="word";
    public static final String meaning1="meaning";
    public static final String wrongMeaning1="wrongMeaning";
    public static final String point1="point";

    //create table for the student_box4
    public static final String Student_box4="Student_box4";
    public static final String Student_name2="Student_name";
    public static final String word2="word";
    public static final String meaning2="meaning";
    public static final String wrongMeaning2="wrongMeaning";
    public static final String point2="point";

    //create table for the student_box5
    public static final String Student_box5="Student_box5";
    public static final String Student_name3="Student_name";
    public static final String word3="word";
    public static final String meaning3="meaning";
    public static final String wrongMeaning3="wrongMeaning";
    public static final String point3="point";

    //create table for the student score in each box
    public static final String Student_Score="Student_Score";
    public static final String boxName="boxName";
    public static final String QuestionNum="QuestionNum";
    public static final String StudentName="StudentName";
    public static final String StudentScore="StudentScore";
    public static final String date="date";

    private SQLiteDatabase db;
    public vocabDatabase(@Nullable Context context) {

        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        //////////////////////admin table creation//////////////////////////////////////////
        db.execSQL("CREATE TABLE "+TableName+"(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstname TEXT NOT NULL, lastname TEXT NOT NULL, username TEXT NOT NULL, email TEXT NOT NULL,  password TEXT NOT NULL)");
        db.execSQL("CREATE TABLE "+TableName2+"(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstname TEXT NOT NULL, lastname TEXT NOT NULL, username TEXT NOT NULL, email TEXT NOT NULL,  password TEXT NOT NULL)");

//for the word insertion by the instructor
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                wordTable.table_name + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                wordTable.column_word + " TEXT, " +
                wordTable.column_option1 + " TEXT, " +
                wordTable.column_option2 + " TEXT " +
                ")";
//for the word insertion by the student in box1//////////////////////////////////////////////////////////
        final String SQL_CREATE_box1_TABLE = "CREATE TABLE " +
                Student_box1 + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student_name + " TEXT, " +
                word + " TEXT, " +
                meaning + " TEXT, " +
                wrongMeaning + " TEXT," +
                point + " INTERGER" +
                ")";
//for the word insertion by the student in box1//////////////////////////////////////////////////////////
        final String SQL_CREATE_box2_TABLE = "CREATE TABLE " +
                Student_box2 + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student_name0 + " TEXT, " +
                word0 + " TEXT, " +
                meaning0 + " TEXT, " +
                wrongMeaning0 + " TEXT," +
                point0 + " INTERGER" +
                ")";
//for the word insertion by the student in box3//////////////////////////////////////////////////////////
        final String SQL_CREATE_box3_TABLE = "CREATE TABLE " +
                Student_box3 + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student_name1 + " TEXT, " +
                word1 + " TEXT, " +
                meaning1 + " TEXT, " +
                wrongMeaning1 + " TEXT," +
                point1 + " INTERGER" +
                ")";
//for the word insertion by the student in box4//////////////////////////////////////////////////////////
        final String SQL_CREATE_box4_TABLE = "CREATE TABLE " +
                Student_box4 + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student_name2 + " TEXT, " +
                word2 + " TEXT, " +
                meaning2 + " TEXT, " +
                wrongMeaning2 + " TEXT," +
                point2 + " INTERGER" +
                ")";
//for the word insertion by the student in box4//////////////////////////////////////////////////////////
        final String SQL_CREATE_box5_TABLE = "CREATE TABLE " +
                Student_box5 + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Student_name3 + " TEXT, " +
                word3 + " TEXT, " +
                meaning3 + " TEXT, " +
                wrongMeaning3 + " TEXT," +
                point3 + " INTERGER" +
                ")";

        //////////////create table for the student score in each box//////////////////////////////////////////////////////////
        final String SQL_CREATE_Score_TABLE = "CREATE TABLE " +
                Student_Score + " ( " +
                wordTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                boxName + " TEXT, " +
                QuestionNum + " INTEGER, " +
                StudentName + " TEXT, " +
                StudentScore + " INTEGER," +
                date + " TEXT" +
                ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_box1_TABLE);
        db.execSQL(SQL_CREATE_box2_TABLE);
        db.execSQL(SQL_CREATE_box3_TABLE);
        db.execSQL(SQL_CREATE_box4_TABLE);
        db.execSQL(SQL_CREATE_box5_TABLE);
        db.execSQL(SQL_CREATE_Score_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  wordTable.table_name);
        db.execSQL("DROP TABLE IF EXISTS "+TableName);
        db.execSQL("DROP TABLE IF EXISTS "+TableName2);
        db.execSQL("DROP TABLE IF EXISTS " +  Student_box1);
        db.execSQL("DROP TABLE IF EXISTS " +  Student_box2);
        db.execSQL("DROP TABLE IF EXISTS " +  Student_box3);
        db.execSQL("DROP TABLE IF EXISTS " +  Student_box4);
        db.execSQL("DROP TABLE IF EXISTS " +  Student_Score);
        onCreate(db);
    }
///////////////////////////////////////////Admin controller ///////////////////////////////////////////
public  boolean insertStudentData(String firstname, String lastname, String username, String email,  String password){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(col1student,firstname);
    contentValues.put(col2student,lastname);
    contentValues.put(col3student,username);
    contentValues.put(col4student,email);
    contentValues.put(col5student,password);
    long result = db.insert(TableName,null,contentValues);
    if (result==-1){
        return false;
    }
    else {
        return true;
    }
}
    public Cursor getRecordOfStudentList(String name){
        db=getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM student WHERE username=?",new String[]{name},null);
        return cursor;
    }
    public Cursor getRecordOfInstructorList(String name){
        db=getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM instructor WHERE username=?",new String[]{name},null);
        return cursor;
    }
    public  boolean insertInstructorData(String firstname, String lastname, String username, String email,  String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1instructor,firstname);
        contentValues.put(col2instructor,lastname);
        contentValues.put(col3instructor,username);
        contentValues.put(col4instructor,email);
        contentValues.put(col5instructor,password);
        long result = db.insert(TableName2,null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor viewstudents(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+TableName;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public Cursor viewinstructors(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+TableName2;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public  boolean checkStudentName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from student where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public  boolean checkInstructorName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from instructor where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public boolean checkCredentialsStudent(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TableName+" where username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkCredentialsInstructor(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TableName2+" where username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteStudent(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TableName, col3student + "=?", new String[]{username})>0;
    }
    public boolean deleteInstructor(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TableName2, col3instructor + "=?", new String[]{username})>0;
    }
    public boolean updateStudent(String firstname, String lastname, String username, String email,  String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1instructor,firstname);
        contentValues.put(col2instructor,lastname);
        contentValues.put(col3instructor,username);
        contentValues.put(col4instructor,email);
        contentValues.put(col5instructor,password);
        return db.update(TableName, contentValues, col3student + "=?", new String[]{username})>0;
    }
    public boolean updateInstructor(String firstname, String lastname, String username, String email,  String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1instructor,firstname);
        contentValues.put(col2instructor,lastname);
        contentValues.put(col3instructor,username);
        contentValues.put(col4instructor,email);
        contentValues.put(col5instructor,password);
        return db.update(TableName2, contentValues, col3instructor + "=?", new String[]{username})>0;
    }
    /////////////////////////////////////////////////Admin controller finishes////////////////////////////////////////


    private void addQuestion(vocabulary question) {
        ContentValues cv = new ContentValues();
        cv.put(wordTable.column_word, question.getWord());
        cv.put(wordTable.column_option1, question.getOption1());
        cv.put(wordTable.column_option2, question.getOption2());
        db.insert(wordTable.table_name, null, cv);
    }
    //vocabulary table
    public List<vocabulary> getRecord(String name){
        List<vocabulary> wordList =new ArrayList<>();
        String subquery="SELECT word FROM Student_box1 Where Student_name=?";
        db=getReadableDatabase();
            Cursor c= db.rawQuery("SELECT * FROM vocab_word WHERE NOT word IN ("+subquery+")",new String[]{name});

        if (c.moveToFirst()){
            do{
                vocabulary vocabulary = new vocabulary();
                vocabulary.setWord(c.getString(c.getColumnIndex(wordTable.column_word)));
                vocabulary.setOption1(c.getString(c.getColumnIndex(wordTable.column_option1)));
                vocabulary.setOption2(c.getString(c.getColumnIndex(wordTable.column_option2)));
                wordList.add(vocabulary);

            }
            while (c.moveToNext());
        }
        c.close();
        return wordList;
    }

    //vocabulary table for the box2 display /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<vocabulary> getRecord2(String name){
        List<vocabulary> wordList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c= db.rawQuery("SELECT word,meaning,wrongMeaning FROM Student_box2 WHERE Student_name=?",new String[]{name});

        if (c.moveToFirst()){
            do{
                vocabulary vocabulary = new vocabulary();
                vocabulary.setWord(c.getString(c.getColumnIndex(word)));
                vocabulary.setOption1(c.getString(c.getColumnIndex(meaning)));
                vocabulary.setOption2(c.getString(c.getColumnIndex(wrongMeaning)));
                wordList.add(vocabulary);

            }
            while (c.moveToNext());
        }
        c.close();
        return wordList;
    }
    //vocabulary table for the box3 display /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<vocabulary> getRecord3(String name){
        List<vocabulary> wordList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c= db.rawQuery("SELECT word,meaning,wrongMeaning FROM Student_box3 WHERE Student_name=?",new String[]{name});

        if (c.moveToFirst()){
            do{
                vocabulary vocabulary = new vocabulary();
                vocabulary.setWord(c.getString(c.getColumnIndex(word1)));
                vocabulary.setOption1(c.getString(c.getColumnIndex(meaning1)));
                vocabulary.setOption2(c.getString(c.getColumnIndex(wrongMeaning1)));
                wordList.add(vocabulary);

            }
            while (c.moveToNext());
        }
        c.close();
        return wordList;
    }
    //vocabulary table for the box4 display /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<vocabulary> getRecord4(String name){
        List<vocabulary> wordList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c= db.rawQuery("SELECT word,meaning,wrongMeaning FROM Student_box4 WHERE Student_name=?",new String[]{name});

        if (c.moveToFirst()){
            do{
                vocabulary vocabulary = new vocabulary();
                vocabulary.setWord(c.getString(c.getColumnIndex(word2)));
                vocabulary.setOption1(c.getString(c.getColumnIndex(meaning2)));
                vocabulary.setOption2(c.getString(c.getColumnIndex(wrongMeaning2)));
                wordList.add(vocabulary);

            }
            while (c.moveToNext());
        }
        c.close();
        return wordList;
    }

    //vocabulary table for the box5 display /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<vocabulary> getRecord5(String name){
        List<vocabulary> wordList =new ArrayList<>();
        db=getReadableDatabase();
        Cursor c= db.rawQuery("SELECT word,meaning,wrongMeaning FROM Student_box5 WHERE Student_name=?",new String[]{name});

        if (c.moveToFirst()){
            do{
                vocabulary vocabulary = new vocabulary();
                vocabulary.setWord(c.getString(c.getColumnIndex(word3)));
                vocabulary.setOption1(c.getString(c.getColumnIndex(meaning3)));
                vocabulary.setOption2(c.getString(c.getColumnIndex(wrongMeaning3)));
                wordList.add(vocabulary);

            }
            while (c.moveToNext());
        }
        c.close();
        return wordList;
    }
    //getRecordOfScore for students from score table /////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public Cursor getRecordOfScore(String name,String boxNO){
        db=getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE StudentName=? AND boxName=? ",new String[]{name,boxNO},null);

        return cursor;
    }



    public boolean insertIntoInstructorTable(String wordinstructor,String meaninginstructor, String wrongmeaninginstructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(wordTable.column_word,wordinstructor);
        contentValues.put(wordTable.column_option1,meaninginstructor);
        contentValues.put(wordTable.column_option2,wrongmeaninginstructor);

        long result= db.insert(wordTable.table_name,null,contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;}

    }

    public boolean getRecordOfInstructorWord(String word) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cour = db.rawQuery("SELECT * FROM vocab_word WHERE word=?", new String[]{word});
        if (cour.getCount() > 0) {

            return true;
        } else {
            return false;
        }
    }
//show all instructor words
Cursor readAllDatainstructor(){
    String query = "SELECT * FROM " + wordTable.table_name;
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = null;
    if(db != null){
        cursor = db.rawQuery(query, null);
    }
    return cursor;
}

    //show all instructor words
 Cursor showBoxesScoreToInstructor(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE boxName='Box 1' order by StudentScore",null);
        return cursor;
    }

    Cursor showBoxesScoreToInstructor2(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE boxName='Box 2' order by StudentScore",null);
        return cursor;
    }
    Cursor showBoxesScoreToInstructor3(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE boxName='Box 3' order by StudentScore",null);
        return cursor;
    }
    Cursor showBoxesScoreToInstructor4(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE boxName='Box 4' order by StudentScore",null);
        return cursor;
    }
    Cursor showBoxesScoreToInstructor5(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM Student_Score WHERE boxName='Box 5' order by StudentScore",null);
        return cursor;
    }
    //insertion into the student_box1 table for the students
    public boolean insertDataIntoBox1(String name, String wordget, String meaningGet, String GetwrongMeaning,int Point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Student_name,name);
        contentValues.put(word,wordget);
        contentValues.put(meaning,meaningGet);
        contentValues.put(wrongMeaning,GetwrongMeaning);
        contentValues.put(point,Point);
        long result= db.insert(Student_box1,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }
    //insertion into the student_box1 table for the students
    public boolean insertDataIntoBox2(String name, String wordget, String meaningGet, String GetwrongMeaning,int Point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Student_name,name);
        contentValues.put(word,wordget);
        contentValues.put(meaning,meaningGet);
        contentValues.put(wrongMeaning,GetwrongMeaning);
        contentValues.put(point,Point);
        long result= db.insert(Student_box2,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }
    //Delete the record from box2
    public Integer deleteFromBox2(String username, String Word){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Student_box2,"Student_name=? AND word=?",new String[]{username,Word});
    }

    //insertion into the student_box3 table for the students
    public boolean insertDataIntoBox3(String name, String wordget, String meaningGet, String GetwrongMeaning,int Point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Student_name1,name);
        contentValues.put(word1,wordget);
        contentValues.put(meaning1,meaningGet);
        contentValues.put(wrongMeaning1,GetwrongMeaning);
        contentValues.put(point1,Point);
        long result= db.insert(Student_box3,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }

    //Delete the record from box3
    public Integer deleteFromBox3(String username, String Word){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Student_box3,"Student_name=? AND word=?",new String[]{username,Word});
    }
    //insertion into the student_box4 table for the students
    public boolean insertDataIntoBox4(String name, String wordget, String meaningGet, String GetwrongMeaning,int Point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Student_name2,name);
        contentValues.put(word2,wordget);
        contentValues.put(meaning2,meaningGet);
        contentValues.put(wrongMeaning2,GetwrongMeaning);
        contentValues.put(point2,Point);
        long result= db.insert(Student_box4,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }
    //Delete the record from box4
    public Integer deleteFromBox4(String username, String Word){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Student_box4,"Student_name=? AND word=?",new String[]{username,Word});
    }
    //insertion into the student_box5 table for the students
    public boolean insertDataIntoBox5(String name, String wordget, String meaningGet, String GetwrongMeaning,int Point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Student_name3,name);
        contentValues.put(word3,wordget);
        contentValues.put(meaning3,meaningGet);
        contentValues.put(wrongMeaning3,GetwrongMeaning);
        contentValues.put(point3,Point);
        long result= db.insert(Student_box5,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }
    //Delete the record from box5
    public Integer deleteFromBox5(String username, String Word){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Student_box5,"Student_name=? AND word=?",new String[]{username,Word});
    }
    //update the final score of a student in the score table
    public Boolean check(String username, String boxnum, String score,String dateNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(StudentScore,score);
        contentValues.put(date,dateNumber);
        Cursor cour = db.rawQuery("SELECT * FROM Student_Score WHERE StudentName=? AND boxName=?",
                new String[]{username,boxnum});
        if (cour.getCount()>0)
        {
            long result= db.update(Student_Score,contentValues,"StudentName=? AND boxName=?",new String[]{username,boxnum});
            if (result == -1){
                return false;}
            else{
                return true;}
        }
        else {
            return false; }
    }



    //insertion into the score table for the students
    public boolean insertData(String box, String question, String name, String score,String dateNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(boxName,box);
        contentValues.put(QuestionNum,question);
        contentValues.put(StudentName,name);
        contentValues.put(StudentScore,score);
        contentValues.put(date,dateNum);

        long result= db.insert(Student_Score,null,contentValues);
        if (result == -1){
            return false;}
        else{
            return true;}
    }

//

}

package com.example.itc335;

public class student_display_progress {
    private String box;
    private int score;
    private int progressBar;
    private int questionNum;



    public student_display_progress(){}

    public student_display_progress(String box, int score, int progressBar,int questionNum) {
        this.box = box;
        this.score = score;
        this.progressBar = progressBar;
        this.questionNum=questionNum;

    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(int progressBar) {
        this.progressBar = progressBar;
    }
    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }
}

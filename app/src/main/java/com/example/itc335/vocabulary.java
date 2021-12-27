package com.example.itc335;

public class vocabulary {

    public vocabulary(){}
    private String word;
    private String option1;
    private String option2;


    public vocabulary(String word, String option1, String option2) {
        this.word = word;
        this.option1 = option1;
        this.option2 = option2;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

}
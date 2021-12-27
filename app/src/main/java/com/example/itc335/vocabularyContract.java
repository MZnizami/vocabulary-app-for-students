package com.example.itc335;

import android.provider.BaseColumns;

public final class vocabularyContract {
    private vocabularyContract(){}

    public static class wordTable implements BaseColumns {
    public static final String table_name="vocab_word";
    public static final String column_word="word";
    public static final String column_option1="option1";
    public static final String column_option2="option2";
    }
}

package com.baybayinapp.thesis.baybayin_app;

import android.provider.BaseColumns;

public final class ReadQuizContract {

    private ReadQuizContract(){

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "answer1";
        public static final String COLUMN_OPTION2 = "answer2";
        public static final String COLUMN_OPTION3 = "answer3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}

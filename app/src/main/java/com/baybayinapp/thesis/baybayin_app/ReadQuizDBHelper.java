package com.baybayinapp.thesis.baybayin_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.baybayinapp.thesis.baybayin_app.*;

import java.util.ArrayList;
import java.util.List;

public class ReadQuizDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ReadQuiiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public ReadQuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                ReadQuizContract.QuestionsTable.TABLE_NAME + " ( " +
                ReadQuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ReadQuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                ReadQuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                ReadQuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                ReadQuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                ReadQuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ReadQuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Questions q1 = new Questions("A", "A", "BA", "KA", 1);
        addQuestion(q1);
        Questions q2 = new Questions("B", "DA", "BA", "GA", 2);
        addQuestion(q2);
        Questions q3 = new Questions("K", "E", "GA", "KA", 3);
        addQuestion(q3);
        Questions q4 = new Questions("D", "DA", "NA", "BA", 1);
        addQuestion(q4);
        Questions q5 = new Questions("E", "BA", "E", "A", 2);
        addQuestion(q5);

        Questions q6 = new Questions("G", "HA", "GA", "PA", 2);
        addQuestion(q6);
        Questions q7 = new Questions("H", "HA", "A", "I", 1);
        addQuestion(q7);
        Questions q8 = new Questions("I", "LA", "SA", "I", 3);
        addQuestion(q8);
        Questions q9 = new Questions("L", "E", "LA", "GA", 2);
        addQuestion(q9);
        Questions q10 = new Questions("M", "A", "KA", "MA", 3);
        addQuestion(q10);

        Questions q11 = new Questions("N", "NA", "NGA", "WA", 2);
        addQuestion(q11);
        Questions q12 = new Questions("ᜈ", "NA", "LA", "NGA", 1);
        addQuestion(q12);
        Questions q13 = new Questions("O", "O", "I", "U", 1);
        addQuestion(q13);
        Questions q14 = new Questions("P", "BA", "PA", "KA", 2);
        addQuestion(q14);
        Questions q15 = new Questions("R", "RA", "WA", "YA", 1);
        addQuestion(q15);

        Questions q16 = new Questions("S", "TA", "SA", "HA", 2);
        addQuestion(q16);
        Questions q17 = new Questions("T", "LA", "YA", "TA", 3);
        addQuestion(q17);
        Questions q18 = new Questions("U", "U", "WA", "GA", 1);
        addQuestion(q18);
        Questions q19 = new Questions("W", "YA", "A", "WA", 3);
        addQuestion(q19);
        Questions q20 = new Questions("Y", "SA", "HA", "YA", 3);
        addQuestion(q20);
    }

    private void addQuestion(Questions questions){
        ContentValues cv = new ContentValues();
        cv.put(ReadQuizContract.QuestionsTable.COLUMN_QUESTION, questions.getQuestion());
        cv.put(ReadQuizContract.QuestionsTable.COLUMN_OPTION1, questions.getAnswer1());
        cv.put(ReadQuizContract.QuestionsTable.COLUMN_OPTION2, questions.getAnswer2());
        cv.put(ReadQuizContract.QuestionsTable.COLUMN_OPTION3, questions.getAnswer3());
        cv.put(ReadQuizContract.QuestionsTable.COLUMN_ANSWER_NR, questions.getAnswerNr());
        db.insert(ReadQuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Questions> getAllQuestions(){
        List<Questions> questionsList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ReadQuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()){
            do{
                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(ReadQuizContract.QuestionsTable.COLUMN_QUESTION)));
                questions.setAnswer1(c.getString(c.getColumnIndex(ReadQuizContract.QuestionsTable.COLUMN_OPTION1)));
                questions.setAnswer2(c.getString(c.getColumnIndex(ReadQuizContract.QuestionsTable.COLUMN_OPTION2)));
                questions.setAnswer3(c.getString(c.getColumnIndex(ReadQuizContract.QuestionsTable.COLUMN_OPTION3)));
                questions.setAnswerNr(c.getInt(c.getColumnIndex(ReadQuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionsList.add(questions);
            } while (c.moveToNext());
        }
        c.close();
        return questionsList;
    }
}

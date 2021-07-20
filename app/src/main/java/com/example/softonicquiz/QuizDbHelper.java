package com.example.softonicquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SoftonicQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;


    public QuizDbHelper( Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                Quiz_contract.QuestionsTable.TABLE_NAME + " ( " +
                Quiz_contract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Quiz_contract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                Quiz_contract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                Quiz_contract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                Quiz_contract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                Quiz_contract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                Quiz_contract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Quiz_contract.QuestionsTable.TABLE_NAME);
        onCreate(db);

    }
    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", "A", "B", "C", "d", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", "d",2);
        addQuestion(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", "d",3);
        addQuestion(q3);
        Question q4 = new Question("A is correct again", "A", "B", "C", "d",1);
        addQuestion(q4);
        Question q5 = new Question("B is correct again", "A", "B", "C", "d",2);
        addQuestion(q5);
    }

    private void addQuestion(Question q1) {
        ContentValues cv = new ContentValues();
        cv.put(Quiz_contract.QuestionsTable.COLUMN_QUESTION, Question.getQuestion());
        cv.put(Quiz_contract.QuestionsTable.COLUMN_OPTION1, Question.getQuestion());
        cv.put(Quiz_contract.QuestionsTable.COLUMN_OPTION2, Question.getQuestion());
        cv.put(Quiz_contract.QuestionsTable.COLUMN_OPTION3, Question.getQuestion());
        cv.put(Quiz_contract.QuestionsTable.COLUMN_OPTION4, Question.getQuestion());
        cv.put(Quiz_contract.QuestionsTable.COLUMN_ANSWER_NR, Question.getQuestion());
        db.insert(Quiz_contract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Quiz_contract.QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(Quiz_contract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}

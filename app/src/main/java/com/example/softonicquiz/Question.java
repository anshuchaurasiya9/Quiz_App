package com.example.softonicquiz;


public class Question {
    private static String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;



    public Question(String question, String option1, String option2, String option3, String option4, int answerNr) {
        this.Question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
    }

    public Question() {

    }

    public static String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        this.Question = Question;
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

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
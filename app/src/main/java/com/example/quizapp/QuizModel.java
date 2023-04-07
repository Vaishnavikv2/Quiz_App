package com.example.quizapp;

public class QuizModel {

    private int mQuestions;
    private boolean mAnswer;

    public QuizModel(int mQuestions, boolean mAnswer) {
        this.mQuestions = mQuestions;
        this.mAnswer = mAnswer;
    }

    public int getQuestions() {
        return mQuestions;
    }

    public void setQuestions(int mQuestions) {
        this.mQuestions = mQuestions;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}

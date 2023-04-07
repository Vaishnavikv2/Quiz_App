package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private Button btnTrue;
    private Button btnWrong;
    private int mQuestionIndex;
    private int mQuizQuestion;

    private ProgressBar mProgressBar;
    private TextView mQuizStatsTextView;

    private int mUserScore;

    private QuizModel[] questionCollection=new QuizModel[]{
            new QuizModel(R.string.q1,true),
            new QuizModel(R.string.q2,false),
            new QuizModel(R.string.q3,true),
            new QuizModel(R.string.q4,false),
            new QuizModel(R.string.q5,true),
            new QuizModel(R.string.q6,false),
            new QuizModel(R.string.q7,true),
            new QuizModel(R.string.q8,false),
            new QuizModel(R.string.q9,true),
            new QuizModel(R.string.q10,false),
    };

    final int USER_PROGRESS =(int)Math.ceil(100.0/ questionCollection.length);

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"OnCreate methods is called",Toast.LENGTH_SHORT).show();

        mTxtQuestion=findViewById(R.id.txtQuestion);
        QuizModel q1=questionCollection[mQuestionIndex];

        mQuizQuestion=q1.getQuestions();
       mTxtQuestion.setText(mQuizQuestion);
       mProgressBar=findViewById(R.id.quizPB);
       mQuizStatsTextView=findViewById(R.id.txtQuizStats);

         btnTrue=findViewById(R.id.btnTrue);



        btnTrue.setOnClickListener(view -> {
            evaluateUsersAnswer(true);
            changeQuestionOnButtonClick();


        });
        btnWrong=findViewById(R.id.btnWrong);
      //  btnWrong.setOnClickListener(myClickListener);
        btnWrong.setOnClickListener(view -> {
            evaluateUsersAnswer(false);
            changeQuestionOnButtonClick();

        });

    }
    private void changeQuestionOnButtonClick(){

        mQuestionIndex=(mQuestionIndex+1)%10;
        if (mQuestionIndex==0){
            AlertDialog.Builder quizAlert=new AlertDialog.Builder(this );
            quizAlert.setCancelable(false);
            quizAlert.setTitle("The quiz is finished");
            quizAlert.setMessage("You score is"+mUserScore);
            quizAlert.setPositiveButton("Finish the quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                     finish();
                }
            });
            quizAlert.show();
        }
        mQuizQuestion=questionCollection[mQuestionIndex].getQuestions();
        mTxtQuestion.setText(mQuizQuestion);
        mProgressBar.incrementProgressBy(USER_PROGRESS);
        mQuizStatsTextView.setText(mUserScore+"");
    }
    private void evaluateUsersAnswer(boolean userGuess){
        boolean currentQuestionAnswer=questionCollection[mQuestionIndex].ismAnswer();
        if (currentQuestionAnswer==userGuess){
            Toast.makeText(getApplicationContext(),R.string.correct_toast_message,Toast.LENGTH_SHORT).show();
            mUserScore= mUserScore+1;
        }else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast_message,Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"OnStart methods is called",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"OnResume methods is called",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"OnPause methods is called",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"OnStop methods is called",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"OnDestroy methods is called",Toast.LENGTH_SHORT).show();
    }
}
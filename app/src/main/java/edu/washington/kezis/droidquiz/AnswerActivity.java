package edu.washington.kezis.droidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnswerActivity extends AppCompatActivity {
    private int correct;
    private int qNum;
    private question curr;
    private ArrayList<question> QA;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);


        QA = (ArrayList<question>) getIntent().getSerializableExtra("QA");
        correct = getIntent().getExtras().getInt("correct");
        qNum = getIntent().getExtras().getInt("qNum");
        String answer = getIntent().getExtras().getString("answer");
        TextView correctTxt = (TextView) findViewById(R.id.correct_answer);
        TextView userAnswer = (TextView) findViewById(R.id.user_answer);
        TextView totalScoreView = (TextView) findViewById(R.id.total_score);
        btn = (Button) findViewById(R.id.next);
        if (qNum <= QA.size() - 2) {
            btn.setText("Next Question");
        } else {
            btn.setText("Finish");
        }

        curr = QA.get(qNum);
        String actualAnswer = curr.getAnswer();
        userAnswer.setText("Your answer is: " + answer);
        correctTxt.setText("The correct answer is: " + actualAnswer);

        if (actualAnswer.equals(answer)) {
            correct++;
        }
        int questionNumber = qNum + 1;
        totalScoreView.setText("You've gotten " +  correct + " out of " + questionNumber + " correct.");
        qNum++;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qNum == QA.size()) {
                    Intent i = new Intent(AnswerActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(AnswerActivity.this, QuestionActivity.class);
                    i.putExtra("fromAnswer", true);
                    i.putExtra("qNum", qNum);
                    i.putExtra("correct", correct);
                    i.putExtra("QA", QA);
                    startActivity(i);
                }
            }
        });



    }
}

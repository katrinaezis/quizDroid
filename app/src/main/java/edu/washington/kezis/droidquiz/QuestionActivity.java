package edu.washington.kezis.droidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    private int qNum;
    private ArrayList<question> QA;
    private String[] answers;
    private int correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        String category = getIntent().getStringExtra("category");
        QA = (ArrayList<question>) getIntent().getSerializableExtra("QA");
        TextView q = (TextView) findViewById(R.id.question);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        Boolean which = getIntent().getExtras().getBoolean("fromAnswer");
        if (which) {
            qNum = getIntent().getExtras().getInt("qNum");
            correct = getIntent().getExtras().getInt("correct");
        } else {
            qNum = 0;
            correct = 0;
        }
        Button next = (Button) findViewById(R.id.next);

        question curr = QA.get(qNum);
        q.setText(curr.getQuestion());
        answers = curr.getAnswers();

        for (int i = 0; i < answers.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answers[i]);
            radioGroup.addView(radioButton);
        }



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectId);
                if (rb == null) {
                    Toast.makeText(QuestionActivity.this,
                            "Please select an answer",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(QuestionActivity.this, AnswerActivity.class);
                    i.putExtra("QA", QA);
                    i.putExtra("qNum", qNum);
                    i.putExtra("correct", correct);
                    i.putExtra("total", answers.length);
                    i.putExtra("answer", rb.getText());
                    startActivity(i);
                }
            }
        });



//
//        TextView CatTxtView = (TextView) findViewById(R.id.category);
//        TextView DescTxtView = (TextView) findViewById(R.id.description);
//
//        TextView QNum = (TextView) findViewById(R.id.q_num);
//        CatTxtView.setText(category);
//       DescTxtView.setText(description);
//        int q = QA.size();
//        QNum.setText(q + " questions");
//
//        Button start = (Button) findViewById(R.id.start);
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                Intent i = new Intent(CatDesc.this, QuestionActivity.class);
//                i.putExtra("QA", QA);
//                startActivity(i);
//                finish();
//            }
//        });


    }
}

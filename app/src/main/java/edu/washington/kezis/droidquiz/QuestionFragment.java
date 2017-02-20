package edu.washington.kezis.droidquiz;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class QuestionFragment extends Fragment {
    private ArrayList<question> QA;
    private int correct;
    private int currNum;
    private int qNum;
    private QuizActivity parent;
    private String[] answers;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (QuizActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.QA = (ArrayList<question>) getArguments().getSerializable("QA");
            this.currNum = getArguments().getInt("currNum");
            this.correct = getArguments().getInt("correct");
            this.qNum = getArguments().getInt("qNum");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        final TextView q = (TextView) view.findViewById(R.id.question);
        Button next = (Button) view.findViewById(R.id.next);
        question curr = QA.get(qNum);
        q.setText(curr.getQuestion());
        answers = curr.getAnswers();

        for (int i = 0; i < answers.length; i++) {
            RadioButton radioButton = new RadioButton(parent);
            radioButton.setText(answers[i]);
            radioGroup.addView(radioButton);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) view.findViewById(selectId);
                if (rb == null) {
                    Toast.makeText(parent,
                            "Please select an answer",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String chosen = (String) rb.getText();
                    parent.answerPage(QA, chosen, qNum, correct);
                }
            }
        });

        return view;
    }
}



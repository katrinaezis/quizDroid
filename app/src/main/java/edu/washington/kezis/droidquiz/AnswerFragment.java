package edu.washington.kezis.droidquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnswerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment {
    private int correct;
    private int qNum;
    private question curr;
    private ArrayList<question> QA;
    private Button btn;
    private String answer;
    QuizActivity parent;

    public AnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (QuizActivity) activity;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(getArguments() != null) {
            super.onCreate(savedInstanceState);
            QA = (ArrayList<question>) getArguments().get("QA");
            correct = getArguments().getInt("correct");
            qNum = getArguments().getInt("qNum");
            String answer = getArguments().getString("answer");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate((R.layout.fragment_answer), container, false);
        TextView correctTxt = (TextView) v.findViewById(R.id.correct_answer);
        curr = QA.get(qNum);
        String actualAnswer = curr.getAnswer();
        correctTxt.setText("The correct answer is: " + actualAnswer);
        TextView userAnswer = (TextView) v.findViewById(R.id.user_answer);
        userAnswer.setText("Your answer is: " + answer);
        TextView totalScoreView = (TextView) v.findViewById(R.id.total_score);
        btn = (Button) v.findViewById(R.id.next);
        if (qNum <= QA.size() - 2) {
            btn.setText("Next Question");
        } else {
            btn.setText("Finish");
        }

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
                    parent.finish();
                } else {
                    parent.nextQuestion(qNum, correct, QA);
                }
            }
        });

        return v;

    }
}

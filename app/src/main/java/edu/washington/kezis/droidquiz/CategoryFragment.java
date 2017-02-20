package edu.washington.kezis.droidquiz;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class CategoryFragment extends Fragment {
    private String category;
    private String description;
    private int qNum;
    private QuizActivity parent;


    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getString("category");
            description = getArguments().getString("description");
            qNum = getArguments().getInt("qNum");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (QuizActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate((R.layout.fragment_category), container, false);
        TextView textView = (TextView) v.findViewById(R.id.category);
        textView.setText(category);
        TextView textView1 = (TextView) v.findViewById(R.id.description);
        textView1.setText(description);
        TextView textView2 = (TextView) v.findViewById(R.id.q_num);
        textView2.setText(qNum + " questions");

        Button start = (Button) v.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                int qNum = 0;
                int correct = 0;
                parent.nextQuestion(qNum, correct);
            }
        });

        return v;
    }
}

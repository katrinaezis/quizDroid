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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
//    TextView CatTxtView = (TextView) findViewById(R.id.category);
//    TextView DescTxtView = (TextView) findViewById(R.id.description);
//
//    TextView QNum = (TextView) findViewById(R.id.q_num);
//    CatTxtView.setText(category);
//    DescTxtView.setText(description);
//    int q = QA.size();
//    QNum.setText(q + " questions");
//
//    Button start = (Button) findViewById(R.id.start);
//    start.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick (View v) {
//            Intent i = new Intent(CatDesc.this, QuestionActivity.class);
//            i.putExtra("QA", QA);
//            startActivity(i);
//            finish();
//        }
//    });
    private String category;
    private String description;
    private int qNum;
    private QuizActivity activity;


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
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (QuizActivity) activity;
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
                Intent i = new Intent(CategoryFragment.this, QuizActivity.class);
                i.putExtra("QA", QA);
                startActivity(i);
                finish();
            }
        });

        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

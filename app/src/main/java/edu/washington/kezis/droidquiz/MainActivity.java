package edu.washington.kezis.droidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] categories = new String[] { "Math", "Physics", "Marvel Super Heroes"};
    private String[] descriptions = new String[] {
            "Nerd stuff", "Even nerdier stuff", "The nerdiest of them all"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView quiz_cat = (ListView) findViewById(R.id.quiz_cat);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                categories);
        quiz_cat.setAdapter(adapter);

        quiz_cat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {

                String selDesc = descriptions[pos];
                String selCat = categories[pos];
                Intent i = new Intent(MainActivity.this, QuizActivity.class);
                i.putExtra("description", selDesc);
                i.putExtra("category", selCat);
                startActivity(i);
            };
        });
    }
}

package edu.washington.kezis.droidquiz;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.*;
import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by iguest on 2/5/17.
 */

public class CatDesc extends AppCompatActivity {
    private ArrayList<question> QA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_desc);

        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");
        QA = new ArrayList<>();

        if (category.equals("Math")) {
            QA.add(new question("What is the term given to the perimeter around a circle?",
                    new String[]{"Area", "Circumference", "Length", "Katrina"}, "Circumference"));
            QA.add(new question("What is the name of the manual calculating device which consists of beads?",
                    new String[]{"Calculator", "Cell Phone Calculator App", "Abacus", "Katrina"}, "Abacus"));
            QA.add(new question("How many sides does a decagon have?",
                    new String[]{"10", "5", "1", "Katrina"}, "10"));
            QA.add(new question("What is two thirds of 270?",
                    new String[]{"10", "5", "180", "Katrina"}, "180"));
        } else if (category.equals("Physics")) {
            QA.add(new question("Radiocarbon is produced in the atmosphere as a result of...",
                    new String[]{"collision between fast neutrons and nitrogen nuclei present in the atmosphere",
                            "action of ultraviolet light from the sun on atmospheric oxygen",
                            "lightning discharge in atmosphere", "Katrina"},
                    "collision between fast neutrons and nitrogen nuclei present in the atmosphere"));
            QA.add(new question("It is easier to roll a stone up a sloping road than to lift it vertical upwards because...",
                    new String[]{"work done in rolling is more than in lifting",
                            "work done in lifting the stone is equal to rolling it",
                            "work done in rolling a stone is less than in lifting it", "Katrina"},
                    "work done in rolling a stone is less than in lifting it"));
            QA.add(new question("The absorption of ink by blotting paper involves",
                    new String[]{"viscosity of ink", "capillary action phenomenon",
                            "diffusion of ink through the blotting", "these are actually p hard"},
                    "capillary action phenomenon"));
            QA.add(new question("Nuclear sizes are expressed in a unit named...",
                    new String[]{"Fermi", "Angstrom", "Newton", "Katrina"}, "Fermi"));
        } else {
            QA.add(new question("The Fantastic Four have the headquarters in what building?",
                    new String[]{"Stark Tower", "Fantastic Headquarters",
                            "Baxter Building", "Katrina"}, "Baxter Building"));
            QA.add(new question("Peter Parker works as a photographer for:",
                    new String[]{"The Daily Planet", "The Daily Bugle",
                            "The New York Times", "Katrina Today"}, "The Daily Bugle"));
            QA.add(new question("Thor has two war goats to pull his chariot. They are named:",
                    new String[]{"Balder and Hermod", "Wtf why goats?",
                            "Toothgrinder and Toothgnasher", "Seriously? Goats?"},
                    "Toothgrinder and Toothgnasher"));
            QA.add(new question("Before becoming Radioactive Man, Chen Lu was:",
                    new String[]{"A nuclear physicist", "Inactive Man",
                            "A spy", "A Katrina"},
                    "A nuclear physicist"));
        }

        TextView CatTxtView = (TextView) findViewById(R.id.category);
        TextView DescTxtView = (TextView) findViewById(R.id.description);

        TextView QNum = (TextView) findViewById(R.id.q_num);
        CatTxtView.setText(category);
        DescTxtView.setText(description);
        int q = QA.size();
        QNum.setText(q + " questions");

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent i = new Intent(CatDesc.this, QuestionActivity.class);
                i.putExtra("QA", QA);
                startActivity(i);
                finish();
            }
        });

    }

}

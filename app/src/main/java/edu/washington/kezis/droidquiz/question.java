package edu.washington.kezis.droidquiz;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by iguest on 2/5/17.
 */

public class question implements Serializable {
    private String question;
    private String[] answers;
    private String answer;

    public question(String question, String[] answers, String answer) {
        this.question = question;
        this.answers = answers;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getAnswer() {
        return answer;
    }
}

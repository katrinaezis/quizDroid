package edu.washington.kezis.droidquiz;

import java.io.Serializable;

/**
 * Created by iguest on 3/6/17.
 */

public class Quiz implements Serializable {
    private String question;
    private int correct;
    private String a1;
    private String a2;
    private String a3;
    private String a4;

    public Quiz(){}

    public String getQuestion() {
        return question;
    }

    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }

    public String getA4() {
        return a4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setA1(String answer) {
        this.a1 = answer;
    }

    public void setA2(String answer) {
        this.a2 = answer;
    }

    public void setA3(String answer) {
        this.a3 = answer;
    }

    public void setA4(String answer) {
        this.a4 = answer;
    }

    public void setCorrect(int index) {
        this.correct = index;
    }
}

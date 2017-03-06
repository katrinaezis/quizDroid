package edu.washington.kezis.droidquiz;

import java.io.Serializable;
import java.util.List;

/**
 * Created by iguest on 3/6/17.
 */

public class Topic implements Serializable {
    private String title;
    private String description;
    private List<question> questionList;

    public Topic(String title, String description, List<question> questionList) {
        this.title = title;
        this.description = description;
        this.questionList = questionList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<question> getQuestionList() {
        return questionList;
    }
}

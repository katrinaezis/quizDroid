package edu.washington.kezis.droidquiz;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by iguest on 2/20/17.
 */

public class QuizApp extends Application {
    public static final String TAG = "QuizApp";


    private TopicRepository instance = null;

    public QuizApp() {
        Log.i(TAG, "I think I did something");
    }

    public TopicRepository getInstance() {
        return instance;
    }

}

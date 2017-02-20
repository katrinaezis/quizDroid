package edu.washington.kezis.droidquiz;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by iguest on 2/20/17.
 */

public class QuizApp extends Application {
    public static final String TAG = "QuizApp";

    @Override
    public void onCreate(){
        Log.i(TAG, "I think I did something");
    }
}

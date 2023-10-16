package com.example.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

public class MessageApplication extends Application {
    public static final String TAG = "MessageApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "MessageApplication -> onTerminate()");

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}

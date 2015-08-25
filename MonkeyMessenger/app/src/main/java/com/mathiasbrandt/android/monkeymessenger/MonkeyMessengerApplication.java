package com.mathiasbrandt.android.monkeymessenger;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by brandt on 25/08/15.
 */
public class MonkeyMessengerApplication extends Application {
    public final static String APPLICATION_ID = "v5OSyzqhZDG46in6EHgcG9gnKG3SfszoMUEkfsvq";
    public final static String CLIENT_KEY = "WhLscrtDVNDwdyTzMr7Upsi1FTkbLugIIdtCGsgw";

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
    }
}

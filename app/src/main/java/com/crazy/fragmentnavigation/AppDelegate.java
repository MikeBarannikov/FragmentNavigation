package com.crazy.fragmentnavigation;

import android.app.Application;

import timber.log.Timber;

/**
 * @author Mike
 */

public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}

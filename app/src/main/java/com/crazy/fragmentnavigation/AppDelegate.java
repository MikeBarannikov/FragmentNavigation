package com.crazy.fragmentnavigation;

import android.app.Application;

import com.crazy.fragmentnavigation.util.LocalCiceroneHolder;

import timber.log.Timber;

/**
 * @author Mike
 */

public class AppDelegate extends Application {

    public static LocalCiceroneHolder sLocalCiceroneHolder = new LocalCiceroneHolder();

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static LocalCiceroneHolder getLocalCiceroneHolder() {
        return sLocalCiceroneHolder;
    }
}

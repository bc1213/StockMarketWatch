package com.barclays.stockmarketwatch.common;

import android.util.Log;

import static com.barclays.stockmarketwatch.AppConfig.isReleaseBuild;

public class PLog {
    private static boolean RELEASE_BUILD = isReleaseBuild();

    public static void i(String TAG, String log) {
        Log.i("Smart::" + TAG, log);
    }

    public static void d(String TAG, String log) {
        if (!RELEASE_BUILD)
            Log.d("Smart::" + TAG, log);
    }

    public static void w(String TAG, String log) {
        Log.w("Smart::" + TAG, log);
    }

    public static void e(String TAG, String log) {
        Log.e("Smart::" + TAG, log);
        if (isReleaseBuild()) {
        }
    }
}

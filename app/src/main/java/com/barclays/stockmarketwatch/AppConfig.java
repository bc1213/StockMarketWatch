package com.barclays.stockmarketwatch;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Build;
import android.util.Log;


import com.barclays.stockmarketwatch.core.db.StockMarketDataBase;

import java.util.List;


public class AppConfig extends Application {
    private static AppConfig mAppConfig;
    public static final boolean FEATURE_SECURE_CONNECTION = isReleaseBuild();
    public static final String TAG = AppConfig.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mAppConfig = this;
        isReleaseBuild();
        Log.d("Helloworld", "App initialized");

        StockMarketDataBase.initDatabase(this);
    }

    /**
     * @return AppConfig instance.
     */

    public static AppConfig getInstance() {
        return mAppConfig;
    }

    /**
     * @return true if APK is signed, or else return false.
     */
    public static boolean isReleaseBuild() {
        return !BuildConfig.DEBUG;
    }

    public static boolean isTablet() {
        return false;
    }

    //Api to check whether the app is in background
    public static boolean isAppIsInBackground() {
        boolean isInBackground = true;
        try {
            ActivityManager am = (ActivityManager) mAppConfig.getSystemService(ACTIVITY_SERVICE);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
                List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                    if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        for (String activeProcess : processInfo.pkgList) {
                            if (activeProcess.equals(mAppConfig.getPackageName())) {
                                isInBackground = false;
                            }
                        }
                    }
                }
            } else {
                List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                ComponentName componentInfo = taskInfo.get(0).topActivity;
                if (componentInfo.getPackageName().equals(mAppConfig.getPackageName())) {
                    isInBackground = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("App in background :", "Something went wrong");
        }

        return isInBackground;
    }


    public static Float getAppVersion() {
        String versionCode = BuildConfig.VERSION_NAME;
        return Float.valueOf(versionCode);
    }

}
package com.example.imgloader.imgloader;

import android.app.Application;

/**
 * Created by admin on 2017/9/11.
 */

public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        if(sInstance == null){
            sInstance = this;
        }
    }

    public static MyApplication getInstance(){
        return sInstance;
    }
}

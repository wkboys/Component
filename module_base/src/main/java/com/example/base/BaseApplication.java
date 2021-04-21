package com.example.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;


import java.util.LinkedList;



public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }



}

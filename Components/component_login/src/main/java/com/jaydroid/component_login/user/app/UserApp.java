package com.jaydroid.component_login.user.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.jaydroid.conponent_base.app.delegate.IAppLife;

/**
 * UserApp
 *
 * @author wangxuejie
 * @version 1.0
 * @date 2019-10-15 10:57
 */
public class UserApp implements IAppLife {

    private static final String TAG = "UserApp";

    @Override
    public void attachBaseContext(Context base) {
        Log.d(TAG, "attachBaseContext");

    }

    @Override
    public void onCreate(Application application) {
        Log.d(TAG, "onCreate");

    }

    @Override
    public void onTerminate(Application application) {
        Log.d(TAG, "onTerminate");

    }
}

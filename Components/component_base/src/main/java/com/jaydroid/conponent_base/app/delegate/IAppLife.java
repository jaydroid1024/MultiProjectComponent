package com.jaydroid.conponent_base.app.delegate;

import android.app.Application;
import android.content.Context;


public interface IAppLife {

    void attachBaseContext(Context base);

    void onCreate(Application application);

    void onTerminate(Application application);

}

package com.jaydroid.base_lib.app

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import com.jaydroid.base_component.app.appdelegate.PriorityLevel
import com.jaydroid.base_lib.app.appdelegate.IAppLife

/**
 * BaseLibApp,反射调用
 *
 * @author wangxuejie
 * @version 1.0
 * @date 2019-10-15 10:57
 */
class BaseLibApp : IAppLife {

    override fun attachBaseContext(base: Context) {
        Log.d(TAG, "attachBaseContext")

    }

    override fun onCreate(application: Application) {
        Log.d(TAG, "onCreate")

    }

    override fun onTerminate(application: Application) {
        Log.d(TAG, "onTerminate")

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLowMemory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTrimMemory(level: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPriority(): String {
        return PriorityLevel.HIGH
    }

    companion object {

        private const val TAG = "BaseLibApp"
    }
}

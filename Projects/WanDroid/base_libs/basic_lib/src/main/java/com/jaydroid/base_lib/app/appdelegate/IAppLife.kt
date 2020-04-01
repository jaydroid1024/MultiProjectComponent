package com.jaydroid.base_lib.app.appdelegate

import android.app.Application
import android.content.Context
import android.content.res.Configuration

/**
 * @author wangxuejie
 * @version 1.0
 * @date 2020/3/31
 */
interface IAppLife {

    fun attachBaseContext(base: Context)

    fun onCreate(application: Application)

    fun onTerminate(application: Application)

    fun onConfigurationChanged(newConfig: Configuration)

    fun onLowMemory()

    fun onTrimMemory(level: Int)

    fun onPriority(): String

    companion object {

        private const val TAG = "IAppLife"
    }

}

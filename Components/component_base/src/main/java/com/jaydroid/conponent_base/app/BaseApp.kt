package com.jaydroid.conponent_base.app

import android.app.Application
import android.content.Context
import android.util.Log

import com.jaydroid.conponent_base.app.delegate.IAppLife
import com.jaydroid.conponent_base.network.default_net.DefaultNetFactory

/**
 * BaseApp
 *
 * @author wangxuejie
 * @version 1.0
 * @date 2019-10-15 10:57
 */
class BaseApp : IAppLife {

    override fun attachBaseContext(base: Context) {
        Log.d(TAG, "attachBaseContext")

    }

    override fun onCreate(application: Application) {
        Log.d(TAG, "onCreate")
        DefaultNetFactory.initialize(application)

    }

    override fun onTerminate(application: Application) {
        Log.d(TAG, "onTerminate")

    }

    companion object {

        private val TAG = "UserApp"
    }
}

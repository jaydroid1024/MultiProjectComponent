package com.jaydroid.conponent_base.app.delegate

import android.app.Application
import android.content.Context


interface IAppLife {

    fun attachBaseContext(base: Context)

    fun onCreate(application: Application)

    fun onTerminate(application: Application)

}

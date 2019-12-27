package com.jaydroid.conponent_base.network.default_net

import android.annotation.SuppressLint
import android.app.Application

/**
 *
 * @author wangxuejie
 * @date 2019-12-25 17:51
 * @version 1.0
 */
object DefaultNetFactory {

    /**
     * 获取应用类实例
     *
     * @return Application
     */
    lateinit var application: Application

    fun initialize(app: Application) {
        application = app
    }

    @SuppressLint("StaticFieldLeak")
    var defaultNetwork: DefaultNetwork? = null
        @Synchronized
        get() {
            if (field == null) {
                field = DefaultNetwork(application.applicationContext!!)
            }
            return field
        }


}
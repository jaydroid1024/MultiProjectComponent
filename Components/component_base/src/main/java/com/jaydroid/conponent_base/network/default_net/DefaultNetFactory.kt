package com.jaydroid.conponent_base.network.default_net

import android.app.Application

/**
 *
 * @author wangxuejie
 * @date 2019-12-25 17:51
 * @version 1.0
 */
class DefaultNetFactory {

    var defaultNetwork: DefaultNetwork? = null
        @Synchronized
        get() {
            if (field == null) {
                field = DefaultNetwork(application.applicationContext!!)
            }
            return field
        }

    companion object {
        /**
         * 获取应用类实例
         *
         * @return Application
         */
        lateinit var application: Application

    }


}
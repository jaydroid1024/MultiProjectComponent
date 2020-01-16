package com.jaydroid.conponent_base.app.delegate

import android.app.Application
import android.content.Context
import android.util.Log

/**
 * Application 代理类
 *
 * @author wangxuejie
 * @version 1.0
 * @date 2019-10-15 10:57
 */
class ApplicationDelegate(base: Context) : IAppLife {


    private var list: List<IAppLife>? = null

    init {
        //初始化Manifest文件解析器，用于解析组件在自己的Manifest文件配置的Application
        list = ManifestParser(base).parse()
    }

    override fun attachBaseContext(base: Context) {
        if (list != null && list!!.isNotEmpty()) {
            for (life in list!!) {
                life.attachBaseContext(base)
            }
        }
    }

    override fun onCreate(application: Application) {
        if (list != null && list!!.isNotEmpty()) {
            for (life in list!!) {
                Log.e(ManifestParser.TAG, "AppLife name: " + life.javaClass.simpleName)
                life.onCreate(application)
            }
        }
    }

    override fun onTerminate(application: Application) {
        if (list != null && list!!.isNotEmpty()) {
            for (life in list!!) {
                life.onTerminate(application)
            }
        }
        list = null
    }
}

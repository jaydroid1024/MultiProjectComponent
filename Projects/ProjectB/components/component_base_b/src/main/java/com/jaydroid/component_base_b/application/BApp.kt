package com.jaydroid.component_base_b.application

import android.app.Application

import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.conponent_base.BuildConfig

/**
 * Description: Application
 *
 * @author xuejiewang
 * @version 1.0
 * @date 2019-09-10
 */
class BApp : Application() {


    override fun onCreate() {
        super.onCreate()

        instance = this

        initRouter()
    }

    /**
     * 初始化Router
     */
    private fun initRouter() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(instance)
    }

    companion object {

        private val TAG = BApp::class.java.simpleName

        /**
         * 获取应用类实例
         *
         * @return BApp
         */
        var instance: BApp? = null
    }
}

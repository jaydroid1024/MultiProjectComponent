package com.jaydroid.conponent_base.app

import android.util.Log

import com.jaydroid.conponent_base.network.default_net.DefaultNetFactory
import com.sankuai.erp.component.appinit.api.SimpleAppInit
import com.sankuai.erp.component.appinit.common.AppInit

/**
 * @author wangxuejie
 * @version 1.0
 * @date 2019-12-26 16:39
 */

/**
 * AppInit 注解属性说明
 * description	初始化的描述信息
 * aheadOf	在指定初始化项之前初始化，用于整个项目范围内重新排序。生成规则为「模块唯一标识:初始化SimpleName」	""
 * onlyForDebug	初始化是否仅在 debug 时可用	false
 * process	在哪个进程初始化。可选值为 Process.MAIN（主进程）、Process.ALL（所有进程）、Process.OTHER（其他进程）	Process.MAIN（主进程）
 * priority	模块内部范围内初始化类的优先级，值越小越先初始化
 */
@AppInit(priority = 40, description = "BaseCommentInit")
class BaseCommentInit : SimpleAppInit() {
    override fun onCreate() {
        Log.d("AppInit", "BaseCommentInit")
        // SimpleAppInit 中包含了 mApplication 和 mIsDebug 属性，可以直接在子类中使用
        DefaultNetFactory.initialize(mApplication)


    }
}

package com.jaydroid.conponent_base.arouter

import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.conponent_base.constant.Constants
import java.util.*

/**
 * 公共路由帮助类
 * @author wangxuejie
 * @date 2019-12-17 14:04
 * @version 1.0
 */
object ARouterHelper {

    object Path {
        /* ========================================================= */
        /* ==================== component_base组件  ================= */
        /* ========================================================= */
        /**
         * 登录服务
         */
        const val LOGIN_SERVICE_PATH = "/component_base/login/service"

        /**
         * 登录服务
         */
        const val GIT_LOGIN_SERVICE_PATH = "/component_base/git_login/service"


        /* ========================================================= */
        /* ==================== component_login组件 ================= */
        /* ========================================================= */
        /**
         * 登录页面
         */
        const val LOGIN_ACTIVITY_PATH = "/component_login/login/activity"

        /**
         * 注册页面
         */
        const val REGISTER_ACTIVITY_PATH = "/component_login/register/activity"


        /* ========================================================= */
        /* ========================= app_a组件  ===================== */
        /* ========================================================= */

        /**
         * Home页面
         */
        const val HOME_ACTIVITY_PATH = "/app_a/home/activity"


        /* ========================================================= */
        /* =================== component_login_a组件 ================ */
        /* ========================================================= */
        /**
         * Git登录页面
         */
        const val LOGIN_GITHUB_ACTIVITY_PATH = "/component_login_a/login/activity"



    }


    /**
     * ARouter通用跳转方法
     */
    fun routerTo(mapParams: HashMap<String, Any>, path: String) {
        ARouter.getInstance()
            .build(path)
            .withSerializable(Constants.IntentKey.MAP_PARAMS, mapParams)
            .navigation()
    }

    /**
     * ARouter通用跳转方法
     */
    fun routerTo(path: String) {
        ARouter.getInstance()
            .build(path)
            .navigation()
    }

    /**
     * 获取Intent参数封装的 HashMap
     */
    fun getParamsMap(capacity: Int): HashMap<String, Any> {
        return HashMap(capacity)
    }

    /**
     * 从HashMap中获取String类型的参数
     */
    fun getParamsMapString(mapParams: HashMap<*, *>?, key: String): String {
        return mapParams?.let {
            it[key] as? String
        } ?: ""
    }

}
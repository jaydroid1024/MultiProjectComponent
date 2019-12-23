package com.jaydroid.conponent_base.arouter.service

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.conponent_base.arouter.ARouterHelper

/**
 * 登录模块对外暴露的服务
 * @author wangxuejie
 * @date 2019-12-17 16:01
 * @version 1.0
 */
@Route(path = ARouterHelper.Path.LOGIN_SERVICE_PATH, name = "登录服务")
class LoginRouterService : ARouterService {

    override fun init(context: Context?) {
    }

    /**
     * 获取登录信息
     */
    fun getLoginData(): String {

        return "Jay"
    }


}
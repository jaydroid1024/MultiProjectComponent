package com.jaydroid.component_login.user.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.component_lib.utils.util.GsonUtils
import com.jaydroid.component_lib.utils.util.SPUtils
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.common.bean.User
import com.jaydroid.conponent_base.constant.Constants

/**
 * 登录模块对外暴露的服务
 * @author wangxuejie
 * @date 2019-12-17 16:01
 * @version 1.0
 */
@Route(path = ARouterHelper.Path.LOGIN_SERVICE_PATH, name = "用户信息服务")
class UserServiceIml : UserService {

    var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    /**
     * 获取登录信息
     */
    fun getLoginData(): User? {
        return GsonUtils.fromJson(
            SPUtils.get(context, Constants.SP.ACCOUNT_LOGIN, "") as String,
            User::class.java
        )
    }

    override fun getUserInfo(): User? {
        return if (SPUtils.contains(context, Constants.SP.ACCOUNT_LOGIN)) {
            GsonUtils.fromJson(
                SPUtils.get(context, Constants.SP.ACCOUNT_LOGIN, "") as String,
                User::class.java
            )
        } else {
            null
        }


    }


    override fun setUserInfo(user: User?) {
        SPUtils.put(context, Constants.SP.ACCOUNT_LOGIN, GsonUtils.toJson(user))
    }


}
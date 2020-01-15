package com.jaydroid.component_login_a.user.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.jaydroid.component_lib.utils.GsonUtils
import com.jaydroid.component_lib.utils.SPUtils
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.GitHubUserService
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.constant.Constants
import com.jaydroid.conponent_base.network.bean.github.GitUser
import com.jaydroid.conponent_base.network.bean.wan.User

/**
 * 登录模块对外暴露的服务
 * @author wangxuejie
 * @date 2019-12-17 16:01
 * @version 1.0
 */
@Route(path = ARouterHelper.Path.GIT_LOGIN_SERVICE_PATH, name = "用户信息服务")
class GitHubUserServiceIml : GitHubUserService {

    var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun getUserInfo(): GitUser? {
        return if (SPUtils.contains(context, Constants.SP.AUTH_GITHUB_TOKEN)) {
            GsonUtils.fromJson(
                SPUtils.get(context, Constants.SP.AUTH_GITHUB_TOKEN, "") as String,
                GitUser::class.java
            )
        } else {
            null
        }

    }


    override fun setUserInfo(user: GitUser?) {
        SPUtils.put(context, Constants.SP.AUTH_GITHUB_TOKEN, GsonUtils.toJson(user))
    }


}
package com.jaydroid.conponent_base.arouter.service.user

import com.alibaba.android.arouter.facade.template.IProvider
import com.jaydroid.conponent_base.network.bean.github.GitUser
import com.jaydroid.conponent_base.network.bean.wan.User

/**
 * 用户服务管理
 * @author wangxuejie
 * @date 2019-12-17 15:58
 * @version 1.0
 */
interface GitHubUserService : IProvider {

    fun getUserInfo(): GitUser?

    fun setUserInfo(user: GitUser?)

}
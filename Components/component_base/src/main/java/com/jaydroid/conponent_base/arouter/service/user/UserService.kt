package com.jaydroid.conponent_base.arouter.service.user

import com.jaydroid.conponent_base.arouter.service.ARouterService
import com.jaydroid.conponent_base.network.bean.wan.User

/**
 * 用户服务管理
 * @author wangxuejie
 * @date 2019-12-17 15:58
 * @version 1.0
 */
interface UserService : ARouterService {

    fun getUserInfo(): User?

    fun setUserInfo(user: User?)

}
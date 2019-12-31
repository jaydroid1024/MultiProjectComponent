package com.jaydroid.conponent_base.arouter.service.user

import com.alibaba.android.arouter.facade.template.IProvider
import com.jaydroid.conponent_base.common.bean.User

/**
 * 用户服务管理
 * @author wangxuejie
 * @date 2019-12-17 15:58
 * @version 1.0
 */
interface UserService : IProvider {

    fun getUserInfo(): User?

    fun setUserInfo(user: User?)

}
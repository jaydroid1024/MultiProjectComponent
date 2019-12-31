package com.jaydroid.component_main_b.main.presenter

import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.component_main_b.main.contract.MainContract
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.base.mvp.BasePresenter

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    var userService: UserService? = null

    init {
        userService =
            ARouter.getInstance().build(ARouterHelper.Path.LOGIN_SERVICE_PATH).navigation() as UserService?


    }

    override fun getUserInfo() {
        val user = userService?.getUserInfo()
        getView()?.onUserInfo(user)
    }

}
package com.jaydroid.component_main_a.presenter

import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.component_main_a.contract.GitMainContract
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.GitHubUserService
import com.jaydroid.conponent_base.base.mvp.BasePresenter

class GitMainPresenter : BasePresenter<GitMainContract.View>(),
    GitMainContract.Presenter {

    var userService: GitHubUserService? = null

    init {
        userService =
            ARouter.getInstance().build(ARouterHelper.Path.GIT_LOGIN_SERVICE_PATH).navigation() as? GitHubUserService
    }

    override fun getUserInfo() {
        val user = userService?.getUserInfo()
        if (user != null) {
            getView()?.onLoginComplete(user)
        } else {
            ARouterHelper.routerTo(ARouterHelper.Path.LOGIN_GITHUB_ACTIVITY_PATH)
        }

    }
}
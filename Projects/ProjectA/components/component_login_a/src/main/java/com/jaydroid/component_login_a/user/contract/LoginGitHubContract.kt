package com.jaydroid.component_login_a.user.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.network.bean.github.BasicToken

interface LoginGitHubContract {

    interface View : IView {
        fun onLoginResult(response: BasicToken)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}

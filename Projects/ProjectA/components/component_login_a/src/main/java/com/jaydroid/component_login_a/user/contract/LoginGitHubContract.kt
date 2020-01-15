package com.jaydroid.component_login_a.user.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.GitUser

interface LoginGitHubContract {

    interface View : IView {
        fun onLoginResult(response: BasicToken)
        fun onLoginComplete(response: GitUser)
    }

    interface Presenter {
        fun login(username: String, password: String)
        fun getUserInfo()
    }
}

package com.jaydroid.component_login.user.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.common.bean.User

interface LoginContract {

    interface View : IView {
        fun onLoginResult(username: String, user: User?)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}

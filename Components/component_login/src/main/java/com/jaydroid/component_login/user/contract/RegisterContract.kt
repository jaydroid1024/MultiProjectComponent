package com.jaydroid.component_login.user.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.common.bean.RegisterResponse

interface RegisterContract {

    interface View : IView {
        fun onRegisterResult(result: RegisterResponse?)
    }

    interface Presenter {
        fun register(username: String, password: String, repassword: String)
    }
}
package com.jaydroid.component_main_b.main.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.network.bean.wan.User

interface MainContract {

    interface View : IView {
        fun onUserInfo(user: User?)
    }

    interface Presenter {
        fun getUserInfo()
    }
}
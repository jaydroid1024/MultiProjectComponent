package com.jaydroid.component_main_a.contract

import com.jaydroid.conponent_base.base.mvp.IView
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.GitUser

interface GitMainContract {

    interface View : IView {
        fun onLoginComplete(response: GitUser)
    }

    interface Presenter {
        fun getUserInfo()
    }
}

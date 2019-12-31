package com.jaydroid.component_login.user.presenter

import com.jaydroid.component_login.user.contract.RegisterContract
import com.jaydroid.conponent_base.base.mvp.BaseObserver
import com.jaydroid.conponent_base.base.mvp.BasePresenter
import com.jaydroid.conponent_base.network.bean.wan.RegisterResponse

class RegisterPresenter : BasePresenter<RegisterContract.View>(), RegisterContract.Presenter {

    override fun register(username: String, password: String, repassword: String) {
        addSubscribe(getDefaultNet().register(username, password, repassword),
            object : BaseObserver<RegisterResponse>() {
                override fun onSuccess(data: RegisterResponse?) {
                    getView()?.onRegisterResult(data)
                }
            })
    }
}
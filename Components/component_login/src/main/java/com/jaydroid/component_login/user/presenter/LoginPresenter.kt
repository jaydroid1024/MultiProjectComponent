package com.jaydroid.component_login.user.presenter

import com.jaydroid.component_login.user.contract.LoginContract
import com.jaydroid.conponent_base.base.mvp.BaseObserver
import com.jaydroid.conponent_base.base.mvp.BasePresenter
import com.jaydroid.conponent_base.network.bean.wan.LoggedInEvent
import com.jaydroid.conponent_base.network.bean.wan.User
import org.greenrobot.eventbus.EventBus

class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(username: String, password: String) {
        addSubscribe(
            getDefaultNet().login(username, password),
            object : BaseObserver<User>(getView()) {
                override fun onSuccess(user: User?) {
                    getView()?.onLoginResult(username, user)
                    EventBus.getDefault().post(
                        LoggedInEvent(
                            user
                        )
                    )
                }
            })
    }
}
package com.jaydroid.component_login_a.user.presenter

import android.util.Log
import com.jaydroid.component_base_a.BuildConfig
import com.jaydroid.component_login_a.user.contract.LoginGitHubContract
import com.jaydroid.conponent_base.base.mvp.BasePresenter
import com.jaydroid.conponent_base.network.bean.github.AuthRequestModel
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import io.reactivex.observers.DisposableObserver
import okhttp3.Credentials

class LoginGitHubPresenter : BasePresenter<LoginGitHubContract.View>(),
    LoginGitHubContract.Presenter {

    private fun generateAuthRequestModel(): AuthRequestModel {
        val model = AuthRequestModel()
        model.scopes = listOf("user", "repo", "gist", "notifications")
        model.note = ""
        model.clientId = BuildConfig.CLIENT_ID
        model.clientSecret = BuildConfig.CLIENT_SECRET
        model.noteUrl = ""
        return model
    }

    override fun login(userName: String, password: String) {
        getView()?.showLoading()
        val authRequestModel = generateAuthRequestModel()
        val token = Credentials.basic(userName, password)

        //todo DisposableObserver
        val a = getGitHubNet().login(authRequestModel)
            .subscribeWith(object : DisposableObserver<BasicToken>() {
                override fun onComplete() {
                    getView()?.dismissLoading()
                }

                override fun onNext(response: BasicToken) {
                    Log.d("login", response.toString())

                    getView()?.onLoginResult(response)

                }

                override fun onError(e: Throwable) {
                }

            })
    }
}
package com.jaydroid.component_login_a.user.presenter

import android.util.Log
import com.jaydroid.component_base_a.BuildConfig
import com.jaydroid.component_login_a.user.contract.LoginGitHubContract
import com.jaydroid.conponent_base.base.mvp.BasePresenter
import com.jaydroid.conponent_base.network.bean.github.AuthRequestModel
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.GitUser
import io.reactivex.observers.DisposableObserver

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
        addSubscribe(
            getGitHubNet().login(authRequestModel)
            .subscribeWith(object : DisposableObserver<BasicToken>() {
                override fun onComplete() {

                }

                override fun onNext(response: BasicToken) {
                    Log.d("login", response.toString())
                    getView()?.onLoginResult(response)

                }

                override fun onError(e: Throwable) {
                }

            })
        )
    }


    override fun getUserInfo() {
        addSubscribe(
            getGitHubNet().getUserInfo()
                .subscribeWith(object : DisposableObserver<GitUser>() {
                    override fun onComplete() {
                        getView()?.dismissLoading()
                    }

                    override fun onNext(response: GitUser) {
                        Log.d("login", response.toString())
                        getView()?.onLoginComplete(response)

                    }

                    override fun onError(e: Throwable) {
                    }

                })
        )
    }
}
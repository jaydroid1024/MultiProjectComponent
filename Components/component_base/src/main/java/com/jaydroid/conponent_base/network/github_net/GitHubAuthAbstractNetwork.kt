package com.jaydroid.conponent_base.network.github_net

import android.content.Context
import com.jaydroid.component_lib.net.AbstractNetwork
import com.jaydroid.component_lib.utils.SPUtils
import com.jaydroid.conponent_base.constant.Constants
import okhttp3.Headers
import okhttp3.OkHttpClient


/**
 * Created by taufiqotulfaidah on 12/21/17.
 */

abstract class GitHubAuthAbstractNetwork<T>(context: Context) : AbstractNetwork<T>(context),
    GitHubAuthorizationInterceptor.HeaderListener {

    private val authInterceptor: GitHubAuthorizationInterceptor
        get() = GitHubAuthorizationInterceptor(this, getToken())

    override fun okHttpClientHandler(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.addInterceptor(authInterceptor)
        return super.okHttpClientHandler(builder)
    }

    override fun onHeaderUpdated(headers: Headers) {

    }

    private fun getToken(): String {
        val token = basicToken()
        return if (token.startsWith("Basic")) token else "token $token"
    }

    private fun basicToken(): String {
        return if (SPUtils.contains(context, Constants.SP.AUTH_GITHUB_TOKEN)) {
            SPUtils.get(context, Constants.SP.AUTH_GITHUB_TOKEN, "") as String
        } else {
            ""
        }
    }

}

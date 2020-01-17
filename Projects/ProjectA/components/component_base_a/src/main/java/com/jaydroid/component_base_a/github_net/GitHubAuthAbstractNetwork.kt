package com.jaydroid.component_base_a.github_net

import android.content.Context
import com.jaydroid.component_lib.net.AbstractNetwork
import okhttp3.Headers
import okhttp3.OkHttpClient


/**
 * Created by taufiqotulfaidah on 12/21/17.
 */

abstract class GitHubAuthAbstractNetwork<T>(context: Context) : AbstractNetwork<T>(context),
    GitHubAuthorizationInterceptor.HeaderListener {

    private val authInterceptor: GitHubAuthorizationInterceptor
        get() = GitHubAuthorizationInterceptor(this, context)

    override fun okHttpClientHandler(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.addInterceptor(authInterceptor)
        return super.okHttpClientHandler(builder)
    }


    override fun onHeaderUpdated(headers: Headers) {

    }


}

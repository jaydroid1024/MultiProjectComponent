package com.jaydroid.component_base_a.github_net

import android.content.Context
import android.util.Log
import com.jaydroid.component_lib.utils.SPUtils
import com.jaydroid.conponent_base.constant.Constants
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by taufiqotulfaidah on 12/21/17.
 */

class GitHubAuthorizationInterceptor(
    private val listener: HeaderListener?,
    val context: Context
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val oriRequest = chain.request()
        val response = chain.proceed(addHeaderAuth(oriRequest))
        listener?.onHeaderUpdated(response.headers)
        return response
    }

    private fun addHeaderAuth(oriRequest: Request): Request {
        Log.d("okhttp", "addHeaderAuth: ${getToken()}")

        return oriRequest.newBuilder()
            .addHeader("Authorization", getToken())
            .build()
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

    interface HeaderListener {

        fun onHeaderUpdated(headers: Headers)
    }
}

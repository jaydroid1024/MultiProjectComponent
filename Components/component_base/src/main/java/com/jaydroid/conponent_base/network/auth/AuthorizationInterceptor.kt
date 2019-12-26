package com.jaydroid.conponent_base.network.auth

import java.io.IOException

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by taufiqotulfaidah on 12/21/17.
 */

class AuthorizationInterceptor(private val listener: HeaderListener?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val oriRequest = chain.request()
        val response = chain.proceed(addHeaderAuth(oriRequest))
        listener?.onHeaderUpdated(response.headers)
        return response
    }

    private fun addHeaderAuth(oriRequest: Request): Request {
        return oriRequest.newBuilder()
            .addHeader("", "")
            .build()
    }

    interface HeaderListener {

        fun onHeaderUpdated(headers: Headers)
    }
}

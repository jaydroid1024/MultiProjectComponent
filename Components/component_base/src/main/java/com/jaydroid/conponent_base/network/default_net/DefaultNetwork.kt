package com.jaydroid.conponent_base.network.default_net

import android.content.Context
import com.jaydroid.conponent_base.network.auth.AuthAbstractNetwork

import io.reactivex.Flowable

/**
 * Created by Jay on 2018/9/27.
 */

class DefaultNetwork(context: Context) : AuthAbstractNetwork<DefaultApiService>(context) {

    override val baseUrl: String
        get() = ""

    override val restClass: Class<DefaultApiService>
        get() = DefaultApiService::class.java


    fun getTrailer(userId: String): Flowable<Any> {
        return getNetworkService()!!.getTrailer(userId)

    }
}

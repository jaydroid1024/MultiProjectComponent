package com.jaydroid.conponent_base.network.default_net

import android.content.Context
import com.jaydroid.conponent_base.network.auth.AuthAbstractNetwork
import com.jaydroid.conponent_base.network.bean.Repo

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by Jay on 2018/9/27.
 */

class DefaultNetwork(context: Context) : AuthAbstractNetwork<DefaultApiService>(context) {

    override val baseUrl: String
        get() = "https://api.github.com/"

    override val restClass: Class<DefaultApiService>
        get() = DefaultApiService::class.java


    fun getListRepos(userId: String): Flowable<List<Repo>> {
        return getNetworkService()!!.listRepos(userId)
    }

    fun getListRepos2(userId: String): Observable<List<Repo>> {
        return getNetworkService()!!.listRepos2(userId)
    }

    fun getListRepos3(userId: String): Call<List<Repo>> {
        return getNetworkService()!!.listRepos3(userId)
    }
}

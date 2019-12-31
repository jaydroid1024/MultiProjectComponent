package com.jaydroid.conponent_base.network.default_net

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.base.BaseResponse
import com.jaydroid.conponent_base.common.bean.RegisterResponse
import com.jaydroid.conponent_base.common.bean.User
import com.jaydroid.conponent_base.network.auth.AuthAbstractNetwork
import com.jaydroid.conponent_base.network.bean.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by Jay on 2018/9/27.
 */

class DefaultNetwork(context: Context) : AuthAbstractNetwork<DefaultApiService>(context) {
    var userService: UserService? = null

    init {
        userService =
            ARouter.getInstance().build(ARouterHelper.Path.LOGIN_SERVICE_PATH).navigation() as UserService?

    }
    override val baseUrl: String
        get() = "https://www.wanandroid.com"

    override val restClass: Class<DefaultApiService>
        get() = DefaultApiService::class.java


    fun getListRepos(userId: String): Flowable<List<Repo>> {
        return getNetworkService()
            .listRepos(userId)
            .compose(RxUtil.applyFlowableTransformer())
    }

    fun getListRepos2(userId: String): Observable<List<Repo>> {
        return getNetworkService()
            .listRepos2(userId)
            .compose(RxUtil.applyObservableTransformer())
    }

    fun getListRepos3(userId: String): Call<List<Repo>> {
        return getNetworkService().listRepos3(userId)
    }


    fun login(name: String, pwd: String): Observable<BaseResponse<User>> {
        return getNetworkService()
            .login(name, pwd)
            .compose(RxUtil.applyObservableTransformer())
            .doOnNext {
                userService?.setUserInfo(it.data)
            }
    }

    fun register(
        name: String,
        pwd: String,
        rPwd: String
    ): Observable<BaseResponse<RegisterResponse>> {
        return getNetworkService()
            .register(name, pwd, rPwd)
            .compose(RxUtil.applyObservableTransformer())
    }


}

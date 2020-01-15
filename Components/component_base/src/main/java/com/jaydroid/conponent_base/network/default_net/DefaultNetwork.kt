package com.jaydroid.conponent_base.network.default_net

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.component_main_b.home.bean.Article
import com.jaydroid.component_main_b.home.bean.ArticleResponse
import com.jaydroid.conponent_base.network.bean.wan.Banner
import com.jaydroid.conponent_base.arouter.ARouterHelper
import com.jaydroid.conponent_base.arouter.service.user.UserService
import com.jaydroid.conponent_base.network.auth.AuthAbstractNetwork
import com.jaydroid.conponent_base.network.bean.github.Repo
import com.jaydroid.conponent_base.network.bean.wan.BaseResponse
import com.jaydroid.conponent_base.network.bean.wan.RegisterResponse
import com.jaydroid.conponent_base.network.bean.wan.User
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

    fun getBanner(): Observable<BaseResponse<List<Banner>>> {
        return getNetworkService()
            .getBanner()
            .compose(RxUtil.applyObservableTransformer())
    }

    fun getTopArticle(): Observable<BaseResponse<List<Article>>>? {
        return getNetworkService()
            .getTopArticle()
            .compose(RxUtil.applyObservableTransformer())

    }

    fun getArticles(page: Int): Observable<BaseResponse<ArticleResponse>>? {
        return getNetworkService()
            .getArticles(page)
            .compose(RxUtil.applyObservableTransformer())
    }


}

package com.jaydroid.conponent_base.network.default_net

import com.jaydroid.conponent_base.base.BaseResponse
import com.jaydroid.conponent_base.common.bean.RegisterResponse
import com.jaydroid.conponent_base.common.bean.User
import com.jaydroid.conponent_base.network.bean.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Jay on 2018/9/27.
 */

interface DefaultApiService {

    /** =======================================================
    Github 开放API：https://developer.github.com/v3/
    baseUrl 请使用：
    https://api.github.com
    ========================================================== */

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Flowable<List<Repo>>

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos2(@Path("user") user: String): Observable<List<Repo>>

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos3(@Path("user") user: String): Call<List<Repo>>


    /** =======================================================
    WanAndroid 开放API：https://www.wanandroid.com/blog/show/2
    baseUrl 请使用：
    https://www.wanandroid.com
    ========================================================== */

    @POST("user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<BaseResponse<User>>


    @POST("user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<BaseResponse<RegisterResponse>>


}

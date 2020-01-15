package com.jaydroid.conponent_base.network.github_net

import com.jaydroid.conponent_base.network.bean.github.AuthRequestModel
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.OauthToken
import com.jaydroid.conponent_base.network.bean.github.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Jay on 2018/9/27.
 */

interface GitHubApiService {

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


    @POST("authorizations")
    @Headers("Accept: application/json")
    fun authorizations(
        @Body authRequestModel: AuthRequestModel
    ): Observable<BasicToken>

    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    fun getAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String,
        @Query("state") state: String
    ): Observable<OauthToken>


}

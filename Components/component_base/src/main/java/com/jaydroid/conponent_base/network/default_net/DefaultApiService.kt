package com.jaydroid.conponent_base.network.default_net

import com.jaydroid.conponent_base.network.bean.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Jay on 2018/9/27.
 */

interface DefaultApiService {

    @GET("/v1/app/videos")
    fun getTrailer(
        @Query("user_id") userId: String
    ): Flowable<Any>

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Flowable<List<Repo>>

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos2(@Path("user") user: String): Observable<List<Repo>>

    //https://api.github.com/users/Jay-Droid/repos
    @GET("users/{user}/repos")
    fun listRepos3(@Path("user") user: String): Call<List<Repo>>
}

package com.jaydroid.conponent_base.network.default_net

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jay on 2018/9/27.
 */

interface DefaultApiService {

    @GET("/v1/app/videos")
    fun getTrailer(
        @Query("user_id") userId: String
    ): Flowable<Any>
}

package com.jaydroid.conponent_base

import android.util.Log
import com.jaydroid.conponent_base.network.bean.Repo
import com.jaydroid.conponent_base.network.default_net.DefaultNetFactory
import io.reactivex.observers.DisposableObserver
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 数据管理类
 * @author wangxuejie
 * @date 2019-12-16 16:41
 * @version 1.0
 */
object DataManager {
    const val TAG = "DataManager"
    /**
     * 获取登录信息
     */
    fun loginRequest(): String {

//        getListRepos()
//        getListRepos2()
        getListRepos3()


        return "jay"
    }

    private fun getListRepos() {
        DefaultNetFactory.getDefaultNet()
            .getListRepos("Jay-Droid")
            .subscribe(object : Subscriber<List<Repo>> {
                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onSubscribe(s: Subscription) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onNext(t: List<Repo>) {
                    Log.d(TAG, "onNext")
                    Log.d(TAG, t?.get(0).toString())

                }

                override fun onError(t: Throwable) {
                    Log.d(TAG, "onError")
                    Log.d(TAG, t?.localizedMessage)
                }

            })
    }


    private fun getListRepos2() {
        DefaultNetFactory.getDefaultNet()
            .getListRepos2("Jay-Droid")
            .subscribe(object : DisposableObserver<List<Repo>>() {
                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }


                override fun onNext(t: List<Repo>) {
                    Log.d(TAG, "onNext")
                    Log.d(TAG, t?.get(0).toString())

                }

                override fun onError(t: Throwable) {
                    Log.d(TAG, "onError")
                    Log.d(TAG, t?.localizedMessage)
                }

            })
    }

    private fun getListRepos3() {
        DefaultNetFactory.getDefaultNet()
            .getListRepos3("Jay-Droid")
            .enqueue(object : Callback<List<Repo>> {
                override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                    Log.d(TAG, "onError")
                    Log.d(TAG, t?.localizedMessage)

                }

                override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                    Log.d(TAG, "onNext")
                    Log.d(TAG, response.body()?.get(0).toString())
                }

            })


    }


}
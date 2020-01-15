package com.jaydroid.conponent_base.network.github_net

import android.content.Context
import com.jaydroid.conponent_base.network.bean.github.AuthRequestModel
import com.jaydroid.conponent_base.network.bean.github.BasicToken
import com.jaydroid.conponent_base.network.bean.github.Repo
import com.jaydroid.conponent_base.network.default_net.RxUtil
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by Jay on 2018/9/27.
 */

class GitHubNetwork(
    context: Context, var configMap: HashMap<String, String>
) : GitHubAuthAbstractNetwork<GitHubApiService>(context) {
    public override val baseUrl: String
        get() = configMap["base_url"]!!

    override val restClass: Class<GitHubApiService>
        get() = GitHubApiService::class.java


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

    fun login(
        authRequestModel: AuthRequestModel
    ): Observable<BasicToken> {
        return getNetworkService()
            .authorizations(authRequestModel)
            .compose(RxUtil.applyObservableTransformer())
    }


}

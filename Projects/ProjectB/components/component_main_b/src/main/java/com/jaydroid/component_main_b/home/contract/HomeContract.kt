package com.jaydroid.component_main_b.home.contract

import com.jaydroid.conponent_base.network.bean.wan.Banner
import com.jaydroid.component_main_b.home.bean.Article
import com.jaydroid.conponent_base.base.mvp.IView


interface HomeContract {
    interface View : IView {

        fun onBanner(list: List<Banner>?)

        fun onArticles(page: Int, list: List<Article>?)
    }

    interface Presenter {

        fun getBanner()

        fun getArticles(page: Int)

    }

}
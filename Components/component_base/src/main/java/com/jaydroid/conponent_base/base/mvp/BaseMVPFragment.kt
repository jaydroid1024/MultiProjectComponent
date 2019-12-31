package com.jaydroid.conponent_base.base.mvp

import com.jaydroid.conponent_base.base.BaseFragment

abstract class BaseMVPFragment<in V : IView, P : IPresenter<in V>> : BaseFragment(), IView {

    protected lateinit var presenter: P

    override fun initData() {
        presenter = createPresenter()
        presenter.attachView(this as V)
    }

    abstract fun createPresenter(): P


}
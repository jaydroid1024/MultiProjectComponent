package com.jaydroid.conponent_base.base.mvp

import com.jaydroid.conponent_base.base.BaseActivity

abstract class BaseMVPActivity<in V : IView, P : IPresenter<in V>> : BaseActivity(), IView {

    protected lateinit var presenter: P

    override fun initData() {
        super.initData()
        presenter = createPresenter()
        presenter.attachView(this as V)
    }

    abstract fun createPresenter(): P


}
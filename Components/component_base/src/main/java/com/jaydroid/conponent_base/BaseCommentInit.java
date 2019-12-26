package com.jaydroid.conponent_base;

import android.util.Log;

import com.jaydroid.conponent_base.network.default_net.DefaultNetFactory;
import com.sankuai.erp.component.appinit.api.SimpleAppInit;
import com.sankuai.erp.component.appinit.common.AppInit;

/**
 * @author wangxuejie
 * @version 1.0
 * @date 2019-12-26 16:39
 */
@AppInit(priority = 40, description = "BaseCommentInit")
public class BaseCommentInit extends SimpleAppInit {
    @Override
    public void onCreate() {
        Log.d("AppInit", "BaseCommentInit");
        // SimpleAppInit 中包含了 mApplication 和 mIsDebug 属性，可以直接在子类中使用
        DefaultNetFactory.application = mApplication;


    }
}

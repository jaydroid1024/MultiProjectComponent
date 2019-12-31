package com.jaydroid.conponent_base.app.delegate;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {

    private static final String TAG = "ManifestParser";
    private static final String MODULE_VALUE = "IModuleConfig";

    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    //通过类名生成实例
    private static IAppLife parseModule(String className) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        Object module;
        try {
            module = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (IAppLife) module;
    }

    public List<IAppLife> parse() {
        List<IAppLife> modules = new ArrayList<>();
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                //会对其中value为IModuleConfig的meta-data进行解析，并通过反射生成实例
                for (String key : appInfo.metaData.keySet()) {
                    if (MODULE_VALUE.equals(appInfo.metaData.get(key))) {
                        int resource = appInfo.metaData.getInt(key);
                        Log.e(TAG, "优先级：" + resource);
                        modules.add(parseModule(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("解析Application失败", e);
        }
        Log.e(TAG, "组件数量:" + modules.size());
        return modules;
    }
}
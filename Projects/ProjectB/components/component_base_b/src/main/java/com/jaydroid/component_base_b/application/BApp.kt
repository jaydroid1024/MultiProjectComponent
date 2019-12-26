package com.jaydroid.component_base_b.application

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.jaydroid.conponent_base.BuildConfig
import com.sankuai.erp.component.appinit.api.AppInitApiUtils
import com.sankuai.erp.component.appinit.api.AppInitManager
import com.sankuai.erp.component.appinit.api.SimpleAppInitCallback
import com.sankuai.erp.component.appinit.common.AppInitItem
import com.sankuai.erp.component.appinit.common.ChildInitTable

/**
 * Description: Application
 *
 * @author xuejiewang
 * @version 1.0
 * @date 2019-09-10
 */
class BApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppInit()

        instance = this

        initRouter()
    }


    private fun initAppInit() {
        val TAG_APP_INIT = "AppInit"
        AppInitManager.get().init(this, object : SimpleAppInitCallback() {
            /**
             * 开始初始化,在所有的初始化类之前初始化
             *
             * @param isMainProcess 是否为主进程
             * @param processName   进程名称
             */
            override fun onInitStart(isMainProcess: Boolean, processName: String?) {
                super.onInitStart(isMainProcess, processName)
                Log.d(TAG_APP_INIT, "isMainProcess, $isMainProcess")
                Log.d(TAG_APP_INIT, "processName, $processName")
            }

            /**
             * 是否为 debug 模式
             */
            override fun isDebug(): Boolean {
                return BuildConfig.DEBUG
            }

            /**
             * 通过 coordinate 自定义依赖关系映射，键值都是 coordinate。「仅在需要发热补的情况下才自定义，否则返回 null」
             *
             * @return 如果返回的 map 不为空，则会在启动是检测依赖并重新排序
             */

            override fun getCoordinateAheadOfMap(): HashMap<String, String> {
                return HashMap()
            }

            /**
             * 同步初始化完成
             *
             * @param isMainProcess      是否为主进程
             * @param processName        进程名称
             * @param childInitTableList 初始化模块列表
             * @param appInitItemList    初始化列表
             */
            override fun onInitFinished(
                isMainProcess: Boolean,
                processName: String?,
                childInitTableList: MutableList<ChildInitTable>?,
                appInitItemList: MutableList<AppInitItem>?
            ) {
                // 获取运行期初始化日val志信息
                val initLogInfo =
                    AppInitApiUtils.getInitOrderAndTimeLog(childInitTableList, appInitItemList)
                Log.d("childInitTableList", childInitTableList.toString())
                Log.d("appInitItemList", appInitItemList.toString())
                Log.d("InitOrderAndTimeLog", initLogInfo)

                Log.d(TAG_APP_INIT, "初始化模块列表, ${childInitTableList.toString()}")
                Log.d(TAG_APP_INIT, "初始化列表, ${appInitItemList.toString()}")
                Log.d(TAG_APP_INIT, "初始化信息, $initLogInfo")
            }

        });

    }

    /**
     * 初始化Router
     */
    private fun initRouter() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(instance)
    }

    companion object {

        private val TAG = BApp::class.java.simpleName

        /**
         * 获取应用类实例
         *
         * @return BApp
         */
        var instance: BApp? = null
    }
}

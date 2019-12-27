package com.jaydroid.component_lib.utils

import com.jaydroid.component_lib.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.LogcatLogStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * @author zhanghao
 * @version 1.0
 */

class L private constructor() {

    init {
        /* cannot be instantiated */
        throw UnsupportedOperationException("cannot be instantiated")
    }

    companion object {

        init {
            val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(LogcatLogStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("jay")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()

            Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
        }

        fun i(msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.i(msg)
            }
        }

        fun i(tag: String, msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.t(tag).i(msg)
            }
        }

        fun d(msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.d(msg)
            }
        }

        fun d(tag: String, msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.t(tag).d(msg)
            }
        }

        fun e(msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.e(msg)
            }
        }

        fun e(tag: String, msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.t(tag).e(msg)
            }
        }

        fun v(msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.v(msg)
            }
        }

        fun v(tag: String, msg: String) {

            if (BuildConfig.DEBUG) {
                Logger.t(tag).v(msg)
            }
        }

        fun json(json: String) {

            if (BuildConfig.DEBUG) {
                Logger.json(json)
            }
        }

        fun json(tag: String, json: String) {

            if (BuildConfig.DEBUG) {
                Logger.t(tag).json(json)
            }
        }
    }
}

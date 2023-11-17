package com.itsao.app.test

import android.app.Application

class AppITSAO: Application() {
    companion object {
        var instance: AppITSAO? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
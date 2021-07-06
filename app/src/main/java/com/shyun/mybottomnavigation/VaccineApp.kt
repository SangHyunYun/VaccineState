package com.shyun.mybottomnavigation

import android.app.Application
import android.content.Context

class VaccineApp : Application() {

    companion object {
        lateinit var applicationCtx: Context
    }

    override fun onCreate() {
        super.onCreate()
        applicationCtx = applicationContext
    }
}
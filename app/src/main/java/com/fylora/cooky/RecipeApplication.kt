package com.fylora.cooky

import android.app.Application
import com.fylora.cooky.core.di.AppModule
import com.fylora.cooky.core.di.AppModuleImpl

class RecipeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }

    companion object {
        lateinit var appModule: AppModule
    }
}
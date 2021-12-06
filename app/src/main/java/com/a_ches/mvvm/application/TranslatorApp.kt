package com.a_ches.mvvm.application

import android.app.Application
import com.a_ches.mvvm.di.application
import com.a_ches.mvvm.di.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
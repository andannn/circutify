package com.andannn.circutify

import android.app.Application
import com.andannn.circutiry.core.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CircutifyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CircutifyApplication)
            modules(networkModule)
        }
    }
}

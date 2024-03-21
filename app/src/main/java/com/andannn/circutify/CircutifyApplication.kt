package com.andannn.circutify

import android.app.Application
import com.andannn.circutify.di.appModules
import com.andannn.circutiry.core.network.di.networkModule
import org.koin.core.context.startKoin

class CircutifyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModules)
            modules(networkModule)
        }
    }
}

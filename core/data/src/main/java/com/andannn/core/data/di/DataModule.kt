package com.andannn.core.data.di

import com.andannn.circutiry.core.network.di.networkModule
import com.andannn.core.data.AuthRepository
import com.andannn.core.data.AuthRepositoryImpl
import org.koin.dsl.module

val dataModule =
    module {
        includes(networkModule)
        single<AuthRepository> { AuthRepositoryImpl(get()) }
    }

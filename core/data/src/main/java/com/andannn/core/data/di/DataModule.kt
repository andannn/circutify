package com.andannn.core.data.di

import com.andannn.circutify.core.datastore.di.dataStoreModule
import com.andannn.circutiry.core.network.di.networkModule
import com.andannn.core.data.AuthRepository
import com.andannn.core.data.AuthRepositoryImpl
import org.koin.dsl.module

val dataModule =
    module {
        includes(networkModule)
        includes(dataStoreModule)
        single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    }

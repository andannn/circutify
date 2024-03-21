package com.andannn.circutiry.core.network.di

import com.andannn.circutiry.core.network.SpotifyService
import com.andannn.circutiry.core.network.SpotifyServiceImpl
import com.andannn.circutiry.core.network.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get

val networkModule =
    module {
        single { httpClient }
        single<SpotifyService> { SpotifyServiceImpl(get(HttpClient::class.java)) }
    }

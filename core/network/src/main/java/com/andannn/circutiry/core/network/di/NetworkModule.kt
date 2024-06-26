package com.andannn.circutiry.core.network.di

import com.andannn.circutiry.core.network.SpotifyAccountService
import com.andannn.circutiry.core.network.SpotifyAccountServiceImpl
import com.andannn.circutiry.core.network.SpotifyResourceService
import com.andannn.circutiry.core.network.SpotifyResourceServiceImpl
import com.andannn.circutiry.core.network.spotifyAccountClientBuilder
import com.andannn.circutiry.core.network.spotifyResourceClientBuilder
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get

val networkModule =
    module {
        single<SpotifyResourceService> { SpotifyResourceServiceImpl(spotifyResourceClientBuilder(get())) }
        single<SpotifyAccountService> { SpotifyAccountServiceImpl(spotifyAccountClientBuilder(get())) }
    }

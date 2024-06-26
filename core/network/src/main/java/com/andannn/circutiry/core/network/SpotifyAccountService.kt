package com.andannn.circutiry.core.network

import com.andannn.circutiry.core.network.dto.AccessToken
import com.andannn.circutiry.core.network.exceptions.SpotifyException
import kotlin.jvm.Throws

interface SpotifyAccountService {
    @Throws(SpotifyException::class)
    suspend fun getToken(
        code: String,
        codeVerifier: String,
    ): AccessToken
}

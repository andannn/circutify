package com.andannn.circutiry.core.network

import android.content.res.Resources
import com.andannn.circutiry.core.network.dto.AccessToken
import com.andannn.circutiry.core.network.exceptions.SpotifyException
import kotlin.jvm.Throws

interface SpotifyAccountService {
    @Throws(SpotifyException::class)
    suspend fun getToken(
        resource: Resources,
        code: String,
        codeVerifier: String,
    ): AccessToken
}

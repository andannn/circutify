package com.andannn.circutiry.core.network

import android.content.res.Resources
import com.andannn.circutiry.core.network.dto.AccessToken
import com.andannn.circutiry.core.network.resources.Token
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.headers

internal class SpotifyAccountServiceImpl(
    private val httpClient: HttpClient,
) : SpotifyAccountService {
    override suspend fun getToken(
        resource: Resources,
        code: String,
        codeVerifier: String,
    ): AccessToken {
        return httpClient
            .post(
                Token(
                    grant_type = "authorization_code",
                    code = code,
                    client_id = resource.getString(R.string.CLIENT_ID),
                    redirect_uri = resource.getString(R.string.REDIRECT_URI),
                    code_verifier = codeVerifier,
                ),
            ) {
                headers {
                    append("Content-Type", "application/x-www-form-urlencoded")
                }
            }.body()
    }
}

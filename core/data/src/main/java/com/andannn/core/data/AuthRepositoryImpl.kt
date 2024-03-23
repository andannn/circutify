package com.andannn.core.data

import android.net.Uri
import com.andannn.circutify.core.datastore.CircutifyDataStore
import com.andannn.circutiry.core.network.SpotifyAccountService
import com.andannn.circutiry.core.network.auth.generateAuthorizationUrl
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import timber.log.Timber

private const val TAG = "AuthRepositoryImpl"

internal class AuthRepositoryImpl(
    private val service: SpotifyAccountService,
    private val dataStore: CircutifyDataStore,
) : AuthRepository {
    private val fallBackEventFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

    override suspend fun loginFlow(onLaunchLoginPage: (Uri) -> Unit): LoginResult {
        val (uri, codeVerifier) = generateAuthorizationUrl()

        onLaunchLoginPage(uri)

        val code = awaitFallBack()

        return try {
            val accessToken = service.getToken(code = code, codeVerifier = codeVerifier)

            dataStore.setAccessToken(
                accessToken = accessToken.accessToken,
                expiresIn = accessToken.expiresIn,
                refreshToken = accessToken.refreshToken,
            )
            LoginResult.Success
        } catch (e: Exception) {
            Timber.tag(TAG).e("loginFlow: failed $e")
            LoginResult.Failed(e)
        }
    }

    override fun notifyLoginFailedBack(code: String) {
        fallBackEventFlow.tryEmit(code)
    }

    private suspend fun awaitFallBack(): String {
        return fallBackEventFlow.first()
    }
}

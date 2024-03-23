package com.andannn.circutiry.core.network

import com.andannn.circutify.core.datastore.CircutifyDataStore
import com.andannn.circutiry.core.network.exceptions.ErrorDto
import com.andannn.circutiry.core.network.exceptions.NetworkException
import com.andannn.circutiry.core.network.exceptions.toSpotifyException
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import timber.log.Timber
import java.util.concurrent.TimeUnit

private const val TAG = "HttpClient"

internal val spotifyResourceClientBuilder: (dataStore: CircutifyDataStore) -> HttpClient =
    { dataStore ->
        HttpClient(OkHttp) {
            commonConfig(dataStore)
            defaultRequest {
                url("https://api.spotify.com/v1/")
            }
        }
    }

internal val spotifyAccountClientBuilder: (dataStore: CircutifyDataStore) -> HttpClient =
    { dataStore ->
        HttpClient(OkHttp) {
            commonConfig(dataStore)
            defaultRequest {
                url("https://accounts.spotify.com")
            }
        }
    }

fun HttpClientConfig<OkHttpConfig>.commonConfig(dataStore: CircutifyDataStore) {
    expectSuccess = true

    install(Logging) {
        logger =
            object : Logger {
                override fun log(message: String) {
                    Timber.tag(TAG).d("HttpLogInfo: $message")
                }
            }
        level = LogLevel.BODY
        sanitizeHeader { header -> header == HttpHeaders.Authorization }
    }
    install(Resources)
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
            },
        )
    }
    install(Auth) {
        bearer {
            loadTokens {
                val accessToken = dataStore.getAccessToken()
                val refreshToken = dataStore.getRefreshToken()
                if (accessToken != null && refreshToken != null) {
                    BearerTokens(accessToken, refreshToken)
                } else {
                    null
                }
            }
        }
    }

    engine {
        config {
            connectTimeout(10, TimeUnit.SECONDS)
        }
    }

    HttpResponseValidator {
        // Common Exception
        handleResponseExceptionWithRequest { exception, _ ->
            if (exception !is ClientRequestException) {
                throw NetworkException(exception.message ?: "")
            }
        }

        // Spotify Exception
        handleResponseExceptionWithRequest { exception, _ ->
            val clientException =
                exception as? ClientRequestException
                    ?: return@handleResponseExceptionWithRequest

            clientException.response.body<ErrorDto>().toSpotifyException()?.let {
                throw it
            } ?: return@handleResponseExceptionWithRequest
        }
    }
}

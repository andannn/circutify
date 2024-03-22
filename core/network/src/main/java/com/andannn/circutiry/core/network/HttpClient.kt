package com.andannn.circutiry.core.network

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

internal val spotifyResourceClient =
    HttpClient(OkHttp) {
        commonConfig("api.spotify.com")
        defaultRequest {
            url("https://api.spotify.com/v1")
        }
    }

internal val spotifyAccountClient =
    HttpClient(OkHttp) {
        commonConfig("accounts.spotify.com")
        defaultRequest {
            url("https://accounts.spotify.com")
        }
    }

fun HttpClientConfig<OkHttpConfig>.commonConfig(host: String) {
    expectSuccess = true

    install(Logging) {
        logger =
            object : Logger {
                override fun log(message: String) {
                    Timber.tag(TAG).d("HttpLogInfo: $message")
                }
            }
        level = LogLevel.BODY
        filter { request ->
            request.url.host.contains(host)
        }
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

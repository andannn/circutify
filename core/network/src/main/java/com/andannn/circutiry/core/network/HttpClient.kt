package com.andannn.circutiry.core.network

import com.andannn.circutiry.core.network.exceptions.ErrorDto
import com.andannn.circutiry.core.network.exceptions.NetworkException
import com.andannn.circutiry.core.network.exceptions.toSpotifyException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.concurrent.TimeUnit

internal val httpClient =
    HttpClient(OkHttp) {
        expectSuccess = true

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
            filter { request ->
                request.url.host.contains("ktor.io")
            }
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
        install(Resources)
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                }
            )
        }


        defaultRequest {
            url("https://api.spotify.com/v1/")
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
                val clientException = exception as? ClientRequestException
                    ?: return@handleResponseExceptionWithRequest

                clientException.response.body<ErrorDto>().toSpotifyException()?.let {
                    throw it
                } ?: return@handleResponseExceptionWithRequest
            }
        }
    }

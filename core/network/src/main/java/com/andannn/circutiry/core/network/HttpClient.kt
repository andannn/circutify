package com.andannn.circutiry.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.HttpHeaders
import java.util.concurrent.TimeUnit

internal val httpClient =
    HttpClient(OkHttp) {
        install(Resources)
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
            filter { request ->
                request.url.host.contains("ktor.io")
            }
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }

        defaultRequest {
            url("https://api.spotify.com/v1/")
        }

        engine {
            config {
                connectTimeout(10, TimeUnit.SECONDS)
            }
        }
    }

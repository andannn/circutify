package com.andannn.circutiry.core.network.exceptions

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import java.lang.Exception
import kotlin.String
import kotlinx.serialization.SerialName

@Serializable
public data class Error(
    @SerialName(value = "status")
    public val status: Int,
    @SerialName(value = "message")
    public val message: String,
)

@Serializable
public data class ErrorDto(
    @SerialName(value = "error")
    public val error: Error,
)

fun ErrorDto.toSpotifyException() =
    when (HttpStatusCode.fromValue(error.status)) {
        HttpStatusCode.Unauthorized -> InvalidTokenException(error.message)
        HttpStatusCode.Forbidden -> BadAuthException(error.message)
        HttpStatusCode.TooManyRequests -> ExceedLimitsException(error.message)
        else -> null
    }

abstract class SpotifyException(override val message: String) : Exception()

/**
 * Any network issue.
 */
class NetworkException(override val message: String) : SpotifyException(message)

/**
 * Bad or expired token. This can happen if the user revoked a token or the access token has expired.
 * You should re-authenticate the user.
 */
class InvalidTokenException(override val message: String) : SpotifyException(message)

/**
 * Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...).
 * Unfortunately, re-authenticating the user won't help here.
 */
class BadAuthException(override val message: String) : SpotifyException(message)

/**
 * The app has exceeded its rate limits.
 */
class ExceedLimitsException(override val message: String) : SpotifyException(message)
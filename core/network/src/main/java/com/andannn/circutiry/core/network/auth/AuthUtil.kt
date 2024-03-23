package com.andannn.circutiry.core.network.auth

import android.net.Uri
import com.andannn.circutiry.core.network.BuildConfig
import io.ktor.http.formUrlEncode
import io.ktor.http.parameters
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

fun generateAuthorizationUrl(): Pair<Uri, String> {
    val codeVerifier = generateRandomString(64)
    val hashed = sha256(codeVerifier)
    val codeChallenge = base64encode(hashed)

    val url = "https://accounts.spotify.com/authorize?"
    return (
        url +
            parameters {
                append("response_type", "code")
                append("client_id", BuildConfig.CLIENT_ID)
                //            append("scope", "scope")
                append("code_challenge_method", "S256")
                append("code_challenge", codeChallenge)
                append("redirect_uri", BuildConfig.REDIRECT_URI)
            }.formUrlEncode()
    ).let { Uri.parse(it) } to codeVerifier
}

private fun generateRandomString(length: Int): String {
    val possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val random = SecureRandom()
    val stringBuilder = StringBuilder(length)
    repeat(length) {
        val randomIndex = random.nextInt(possible.length)
        stringBuilder.append(possible[randomIndex])
    }
    return stringBuilder.toString()
}

private fun sha256(plain: String): ByteArray {
    val digest = MessageDigest.getInstance("SHA-256")
    val encodedBytes = plain.toByteArray(StandardCharsets.UTF_8)
    return digest.digest(encodedBytes)
}

@OptIn(ExperimentalEncodingApi::class)
private fun base64encode(input: ByteArray): String {
    val base64String = Base64.Default.encode(input)
    return base64String
        .replace("=", "")
        .replace("+", "-")
        .replace("/", "_")
}

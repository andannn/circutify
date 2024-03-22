package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class AccessToken(
    @SerialName(value = "access_token")
    public val accessToken: String,
    @SerialName(value = "token_type")
    public val tokenType: String,
    @SerialName(value = "expires_in")
    public val expiresIn: Int,
    @SerialName(value = "refresh_token")
    public val refreshToken: String,
)

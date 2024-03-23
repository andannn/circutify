package com.andannn.core.data.modle

data class TokenModel(
    val accessToken: String,
    val expiresIn: Int,
    val refreshToken: String,
)

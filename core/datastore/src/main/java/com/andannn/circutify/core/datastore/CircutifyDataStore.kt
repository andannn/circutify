package com.andannn.circutify.core.datastore

interface CircutifyDataStore {
    suspend fun getAccessToken(): String?

    suspend fun getRefreshToken(): String?

    suspend fun setAccessToken(
        accessToken: String,
        expiresIn: Int,
        refreshToken: String,
    )
}

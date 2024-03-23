package com.andannn.circutify.core.datastore

interface CircutifyDataStore {
    suspend fun getAccessToken(): AccessToken?

    suspend fun setAccessToken(
        accessToken: String,
        expiresIn: Int,
        refreshToken: String,
    )
}

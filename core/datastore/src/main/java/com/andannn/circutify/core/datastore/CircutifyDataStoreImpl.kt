package com.andannn.circutify.core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.firstOrNull

class CircutifyDataStoreImpl(
    private val dataStore: DataStore<CircutifyPreferences>,
) : CircutifyDataStore {
    override suspend fun getAccessToken(): String? {
        return dataStore.data.firstOrNull()?.accessTokenOrNull?.accessToken
    }

    override suspend fun getRefreshToken(): String? {
        return dataStore.data.firstOrNull()?.accessTokenOrNull?.refreshToken
    }

    override suspend fun setAccessToken(
        accessToken: String,
        expiresIn: Int,
        refreshToken: String,
    ) {
        dataStore.updateData { preference ->
            preference.copy {
                this.accessToken.copy {
                    this.accessToken = accessToken
                    this.expiresIn = expiresIn
                    this.refreshToken = refreshToken
                }
            }
        }
    }
}

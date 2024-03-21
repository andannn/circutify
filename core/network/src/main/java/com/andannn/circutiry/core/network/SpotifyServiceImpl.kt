package com.andannn.circutiry.core.network

import android.util.Log
import com.andannn.circutiry.core.network.dto.Album
import com.andannn.circutiry.core.network.resources.AlbumRes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get

internal class SpotifyServiceImpl(
    private val httpClient: HttpClient,
) : SpotifyService {
    override suspend fun getAlbumById(id: String): Album {
        Log.d("JQN", "getAlbumById: $id")
        return httpClient.get(AlbumRes.Id(id = id)).body()
    }
}

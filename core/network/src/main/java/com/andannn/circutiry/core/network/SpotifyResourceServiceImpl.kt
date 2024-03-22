package com.andannn.circutiry.core.network

import com.andannn.circutiry.core.network.dto.Album
import com.andannn.circutiry.core.network.resources.AlbumRes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get

internal class SpotifyResourceServiceImpl(
    private val httpClient: HttpClient,
) : SpotifyResourceService {
    override suspend fun getAlbumById(id: String): Album? {
        return httpClient.get(AlbumRes.Id(id = id)).body()
    }
}

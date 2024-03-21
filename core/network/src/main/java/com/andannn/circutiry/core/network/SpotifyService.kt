package com.andannn.circutiry.core.network

import com.andannn.circutiry.core.network.dto.Album

interface SpotifyService {
    suspend fun getAlbumById(id: String): Album?
}

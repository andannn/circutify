package com.andannn.circutiry.core.network

import com.andannn.circutiry.core.network.dto.Album
import com.andannn.circutiry.core.network.exceptions.SpotifyException

interface SpotifyService {

    @Throws(SpotifyException::class)
    suspend fun getAlbumById(id: String): Album?
}

package com.andannn.core.data

import com.andannn.circutiry.core.network.dto.Album
import java.lang.Exception

sealed interface LoadResult<T> {
    data class Success<T>(val data: T) : LoadResult<T>

    data class Failed<T>(val exception: Exception) : LoadResult<T>
}

interface ResourceRepository {
    suspend fun getAlbumById(id: String): LoadResult<Album?>
}

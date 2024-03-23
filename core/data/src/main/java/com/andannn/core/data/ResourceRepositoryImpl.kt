package com.andannn.core.data

import com.andannn.circutiry.core.network.SpotifyResourceService
import com.andannn.circutiry.core.network.dto.Album

internal class ResourceRepositoryImpl(
    private val resourceService: SpotifyResourceService,
) : ResourceRepository {
    override suspend fun getAlbumById(id: String): LoadResult<Album?> {
        return try {
            return resourceService.getAlbumById(id).let {
                LoadResult.Success(it)
            }
        } catch (e: Exception) {
            LoadResult.Failed(e)
        }
    }
}

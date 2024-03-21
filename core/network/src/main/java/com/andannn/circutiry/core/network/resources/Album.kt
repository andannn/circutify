package com.andannn.circutiry.core.network.resources

import io.ktor.resources.Resource

@Resource("albums")
class AlbumRes {
    @Resource("{id}")
    class Id(val parent: AlbumRes = AlbumRes(), val id: String)
}

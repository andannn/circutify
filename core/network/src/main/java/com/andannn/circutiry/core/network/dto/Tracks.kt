package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
public data class Tracks(
    @SerialName(value = "tracks")
    public val tracks: List<Track>,
)

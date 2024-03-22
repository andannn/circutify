package com.andannn.circutiry.core.network.dto

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Tracks(
  @SerialName(value = "tracks")
  public val tracks: List<Track>,
)

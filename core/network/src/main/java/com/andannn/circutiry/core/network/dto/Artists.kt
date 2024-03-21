package com.andannn.circutiry.core.network.dto

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Artists(
  @SerialName(value = "artists")
  public val artists: List<Artist>,
)

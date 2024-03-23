package com.andannn.circutiry.core.network.dto

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExternalIds(
  @SerialName(value = "upc")
  public val upc: String,
)

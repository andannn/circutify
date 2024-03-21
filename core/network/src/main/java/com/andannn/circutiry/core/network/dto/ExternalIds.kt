package com.andannn.circutiry.core.network.dto

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExternalIds(
  @SerialName(value = "isrc")
  public val isrc: String,
  @SerialName(value = "ean")
  public val ean: String,
  @SerialName(value = "upc")
  public val upc: String,
)

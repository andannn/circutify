package com.andannn.circutiry.core.network.dto

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Image(
  @SerialName(value = "url")
  public val url: String,
  @SerialName(value = "height")
  public val height: Double,
  @SerialName(value = "width")
  public val width: Double,
)

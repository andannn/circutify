package com.andannn.circutiry.core.network.dto

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Copyright(
  @SerialName(value = "text")
  public val text: String,
  @SerialName(value = "type")
  public val type: String,
)

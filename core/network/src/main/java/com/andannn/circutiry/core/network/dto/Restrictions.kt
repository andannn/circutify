package com.andannn.circutiry.core.network.dto

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Restrictions(
  @SerialName(value = "reason")
  public val reason: String,
)

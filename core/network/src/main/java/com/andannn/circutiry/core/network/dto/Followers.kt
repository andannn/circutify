package com.andannn.circutiry.core.network.dto

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Followers(
  @SerialName(value = "href")
  public val href: String,
  @SerialName(value = "total")
  public val total: Double,
)

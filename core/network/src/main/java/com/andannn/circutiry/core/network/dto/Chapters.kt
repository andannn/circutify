package com.andannn.circutiry.core.network.dto

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Chapters(
  @SerialName(value = "href")
  public val href: String,
  @SerialName(value = "limit")
  public val limit: Double,
  @SerialName(value = "next")
  public val next: String,
  @SerialName(value = "offset")
  public val offset: Double,
  @SerialName(value = "previous")
  public val previous: String,
  @SerialName(value = "total")
  public val total: Double,
  @SerialName(value = "items")
  public val items: List<Item>,
)

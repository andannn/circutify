package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Categories(
  @SerialName(value = "categories")
  public val categories: Categories,
)

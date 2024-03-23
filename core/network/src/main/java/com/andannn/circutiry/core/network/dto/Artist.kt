package com.andannn.circutiry.core.network.dto

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Artist(
  @SerialName(value = "external_urls")
  public val externalUrls: ExternalUrls,
  @SerialName(value = "href")
  public val href: String,
  @SerialName(value = "id")
  public val id: String,
  @SerialName(value = "name")
  public val name: String,
  @SerialName(value = "type")
  public val type: String,
  @SerialName(value = "uri")
  public val uri: String,
)

package com.andannn.circutiry.core.network.dto

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Artist(
  @SerialName(value = "external_urls")
  public val externalUrls: ExternalUrls,
  @SerialName(value = "followers")
  public val followers: Followers,
  @SerialName(value = "genres")
  public val genres: List<String>,
  @SerialName(value = "href")
  public val href: String,
  @SerialName(value = "id")
  public val id: String,
  @SerialName(value = "images")
  public val images: List<Image>,
  @SerialName(value = "name")
  public val name: String,
  @SerialName(value = "popularity")
  public val popularity: Double,
  @SerialName(value = "type")
  public val type: String,
  @SerialName(value = "uri")
  public val uri: String,
)

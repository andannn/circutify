package com.andannn.circutiry.core.network.dto

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AudioBook(
  @SerialName(value = "authors")
  public val authors: List<Author>,
  @SerialName(value = "available_markets")
  public val availableMarkets: List<String>,
  @SerialName(value = "copyrights")
  public val copyrights: List<Copyright>,
  @SerialName(value = "description")
  public val description: String,
  @SerialName(value = "html_description")
  public val htmlDescription: String,
  @SerialName(value = "edition")
  public val edition: String,
  @SerialName(value = "explicit")
  public val explicit: Boolean,
  @SerialName(value = "external_urls")
  public val externalUrls: ExternalUrls,
  @SerialName(value = "href")
  public val href: String,
  @SerialName(value = "id")
  public val id: String,
  @SerialName(value = "images")
  public val images: List<Image>,
  @SerialName(value = "languages")
  public val languages: List<String>,
  @SerialName(value = "media_type")
  public val mediaType: String,
  @SerialName(value = "name")
  public val name: String,
  @SerialName(value = "narrators")
  public val narrators: List<Narrator>,
  @SerialName(value = "publisher")
  public val publisher: String,
  @SerialName(value = "type")
  public val type: String,
  @SerialName(value = "uri")
  public val uri: String,
  @SerialName(value = "total_chapters")
  public val totalChapters: Double,
  @SerialName(value = "chapters")
  public val chapters: Chapters,
)

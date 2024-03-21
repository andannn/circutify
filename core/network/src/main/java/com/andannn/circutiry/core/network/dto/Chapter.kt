package com.andannn.circutiry.core.network.dto

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Chapter(
  @SerialName(value = "audio_preview_url")
  public val audioPreviewUrl: String,
  @SerialName(value = "available_markets")
  public val availableMarkets: List<String>,
  @SerialName(value = "chapter_number")
  public val chapterNumber: Double,
  @SerialName(value = "description")
  public val description: String,
  @SerialName(value = "html_description")
  public val htmlDescription: String,
  @SerialName(value = "duration_ms")
  public val durationMs: Double,
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
  @SerialName(value = "is_playable")
  public val isPlayable: Boolean,
  @SerialName(value = "languages")
  public val languages: List<String>,
  @SerialName(value = "name")
  public val name: String,
  @SerialName(value = "release_date")
  public val releaseDate: String,
  @SerialName(value = "release_date_precision")
  public val releaseDatePrecision: String,
  @SerialName(value = "resume_point")
  public val resumePoint: ResumePoint,
  @SerialName(value = "type")
  public val type: String,
  @SerialName(value = "uri")
  public val uri: String,
  @SerialName(value = "restrictions")
  public val restrictions: Restrictions,
  @SerialName(value = "audiobook")
  public val audiobook: Audiobook,
)

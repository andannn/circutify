package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Track(
    @SerialName(value = "album")
    public val album: Album,
    @SerialName(value = "artists")
    public val artists: List<Artist>,
    @SerialName(value = "available_markets")
    public val availableMarkets: List<String>,
    @SerialName(value = "disc_number")
    public val discNumber: Double,
    @SerialName(value = "duration_ms")
    public val durationMs: Double,
    @SerialName(value = "explicit")
    public val explicit: Boolean,
    @SerialName(value = "external_ids")
    public val externalIds: ExternalIds,
    @SerialName(value = "external_urls")
    public val externalUrls: ExternalUrls,
    @SerialName(value = "href")
    public val href: String,
    @SerialName(value = "id")
    public val id: String,
    @SerialName(value = "is_playable")
    public val isPlayable: Boolean,
    @SerialName(value = "restrictions")
    public val restrictions: Restrictions,
    @SerialName(value = "name")
    public val name: String,
    @SerialName(value = "popularity")
    public val popularity: Double,
    @SerialName(value = "preview_url")
    public val previewUrl: String,
    @SerialName(value = "track_number")
    public val trackNumber: Double,
    @SerialName(value = "type")
    public val type: String,
    @SerialName(value = "uri")
    public val uri: String,
    @SerialName(value = "is_local")
    public val isLocal: Boolean,
)

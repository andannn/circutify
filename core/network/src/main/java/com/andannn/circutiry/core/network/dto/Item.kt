package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Item(
    @SerialName(value = "artists")
    public val artists: List<Artist>,
    @SerialName(value = "available_markets")
    public val availableMarkets: List<String>,
    @SerialName(value = "disc_number")
    public val discNumber: Int,
    @SerialName(value = "duration_ms")
    public val durationMs: Int,
    @SerialName(value = "explicit")
    public val explicit: Boolean,
    @SerialName(value = "external_urls")
    public val externalUrls: ExternalUrls,
    @SerialName(value = "href")
    public val href: String,
    @SerialName(value = "id")
    public val id: String,
    @SerialName(value = "is_local")
    public val isLocal: Boolean,
    @SerialName(value = "name")
    public val name: String,
    @SerialName(value = "preview_url")
    public val previewUrl: String? = null,
    @SerialName(value = "track_number")
    public val trackNumber: Int,
    @SerialName(value = "type")
    public val type: String,
    @SerialName(value = "uri")
    public val uri: String,
)

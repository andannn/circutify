package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Album(
    @SerialName(value = "album_type")
    public val albumType: String,
    @SerialName(value = "artists")
    public val artists: List<Artist>,
    @SerialName(value = "available_markets")
    public val availableMarkets: List<String>,
    @SerialName(value = "copyrights")
    public val copyrights: List<Copyright>,
    @SerialName(value = "external_ids")
    public val externalIds: ExternalIds,
    @SerialName(value = "external_urls")
    public val externalUrls: ExternalUrls,
    @SerialName(value = "genres")
    public val genres: List<String>,
    @SerialName(value = "href")
    public val href: String,
    @SerialName(value = "id")
    public val id: String,
    @SerialName(value = "images")
    public val images: List<Image>,
    @SerialName(value = "label")
    public val label: String,
    @SerialName(value = "name")
    public val name: String,
    @SerialName(value = "popularity")
    public val popularity: Int,
    @SerialName(value = "release_date")
    public val releaseDate: String,
    @SerialName(value = "release_date_precision")
    public val releaseDatePrecision: String,
    @SerialName(value = "total_tracks")
    public val totalTracks: Int,
    @SerialName(value = "tracks")
    public val tracks: Tracks,
    @SerialName(value = "type")
    public val type: String,
    @SerialName(value = "uri")
    public val uri: String,
)

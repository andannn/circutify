package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Tracks(
    @SerialName(value = "href")
    public val href: String,
    @SerialName(value = "items")
    public val items: List<Item>,
    @SerialName(value = "limit")
    public val limit: Int,
    @SerialName(value = "offset")
    public val offset: Int,
    @SerialName(value = "next")
    public val next: Int? = null,
    @SerialName(value = "previous")
    public val previous: Int? = null,
    @SerialName(value = "total")
    public val total: Int,
)

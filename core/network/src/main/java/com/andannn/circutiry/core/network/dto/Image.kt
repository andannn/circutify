package com.andannn.circutiry.core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@Serializable
public data class Image(
    @SerialName(value = "height")
    public val height: Int,
    @SerialName(value = "url")
    public val url: String,
    @SerialName(value = "width")
    public val width: Int,
)

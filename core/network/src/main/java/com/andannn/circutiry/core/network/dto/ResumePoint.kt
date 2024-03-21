package com.andannn.circutiry.core.network.dto

import kotlin.Boolean
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ResumePoint(
  @SerialName(value = "fully_played")
  public val fullyPlayed: Boolean,
  @SerialName(value = "resume_position_ms")
  public val resumePositionMs: Double,
)

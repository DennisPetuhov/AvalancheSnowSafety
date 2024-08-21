package com.ass.network.models.assFile.assFile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TemplateVersion(
    @SerialName("major")
    val major: Int,
    @SerialName("minor")
    val minor: Int,
    @SerialName("patch")
    val patch: Int,
)
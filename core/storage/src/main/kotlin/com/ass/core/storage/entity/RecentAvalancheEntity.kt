package com.ass.core.storage.entity

import kotlinx.serialization.Serializable
import kotlin.String

@kotlinx.serialization.InternalSerializationApi
@Serializable
data class RecentAvalancheEntity(
    val date: String,
    val size: String,
    val aspect: List<String>,
    val elevation: String,
    val triggeredBy: String,
    val type: String,
    val description: String
) {
    companion object {
        val EMPTY = RecentAvalancheEntity("", "", emptyList<String>(), "", "", "", "")
    }
}

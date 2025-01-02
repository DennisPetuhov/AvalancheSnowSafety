package com.ass.core.storage.entity

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class HazardRatingEntity(
    val highAlpine: String,
    val alpine: String,
    val subAlpine: String,
    val overAll: String
) {
    companion object {
        val EMPTY =HazardRatingEntity("", "", "", "")
    }
}
package com.ass.core.storage.entity

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
@InternalSerializationApi
@Serializable
data class IssuedAtEntity(val time: String, val validTo: String, val forecaster: String) {
    companion object {
        val EMPTY = IssuedAtEntity(time = "", validTo = "", forecaster = "")
    }
}

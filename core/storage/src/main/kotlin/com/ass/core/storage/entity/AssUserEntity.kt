package com.ass.core.storage.entity

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
@InternalSerializationApi
@Serializable
data class AssUserEntity(
    val name: String,
    val secondName: String,
    val email: String,
    val phone: String
) {
    companion object {
        val EMPTY_USER = AssUserEntity("", "", "", "")
    }
}
package com.ass.core.storage.entity

import kotlinx.serialization.Serializable

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
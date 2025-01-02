package com.ass.core.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ass.core.storage.utill.AssConverters
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
@Entity
@TypeConverters(AssConverters::class)
data class AssBulletinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val avalancheProblems: List<AvalancheProblemEntity>,
    val mainDescription: String,
    val hazardRatings: HazardRatingEntity,
    val recentAvalanches: List<RecentAvalancheEntity>,
    val snowPack: String,
    val weather: String,
    val issuedAt: IssuedAtEntity = IssuedAtEntity.EMPTY
)
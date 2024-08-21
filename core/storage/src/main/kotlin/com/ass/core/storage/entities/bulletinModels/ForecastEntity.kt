package com.ass.core.storage.entities.bulletinModels
import kotlinx.serialization.Serializable

@Serializable
data class ForecastEntity(
    val detailsEntity: DetailsEntity,
//    val assFilePathEntity: AssFilePathEntity,
//    val hazardRatingsEntity: HazardRatingsEntity,
)
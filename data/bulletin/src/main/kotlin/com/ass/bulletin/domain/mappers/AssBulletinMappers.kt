package com.ass.bulletin.domain.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.ass.bulletin.domain.models.AssBulletin
import com.ass.bulletin.domain.models.AvalancheProblem
import com.ass.bulletin.domain.models.BulletinMetadata
import com.ass.bulletin.domain.models.HazardRatings
import com.ass.bulletin.domain.models.RecentAvalanche
import com.ass.core.storage.entity.AssBulletinEntity
import com.ass.core.storage.entity.AvalancheProblemEntity
import com.ass.core.storage.entity.HazardRatingEntity
import com.ass.core.storage.entity.IssuedAtEntity
import com.ass.core.storage.entity.RecentAvalancheEntity
import com.ass.network.models.AssResponse
import com.ass.network.models.assModels.AvalancheProblemResponse
import com.ass.network.models.assModels.HazardRatingsResponse
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun AssResponse.toEntity(): AssBulletinEntity {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
    val displayFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm")
    val time = ZonedDateTime.parse(this.currentForecast?.forecast?.time ?: "", formatter)
    val validTo = time.plusSeconds(this.currentForecast?.forecast?.validFor?.toLong() ?: 0L)
    println("@@@@: ${this.currentForecast?.forecast?.recentObservations?.en?.toListOfRecentAvalancheEntity()}@@@@")
    return AssBulletinEntity(
        id = 1,
        mainDescription = this.currentForecast?.forecast?.description?.en ?: "",
        hazardRatings = this.currentForecast?.forecast?.hazardRatingsResponse?.toEntity()
            ?: HazardRatingEntity.EMPTY,
        avalancheProblems = this.currentForecast?.forecast?.avalancheProblemResponses?.toEntity()
            ?: emptyList(),
        recentAvalanches = this.currentForecast?.forecast?.recentObservations?.en?.toListOfRecentAvalancheEntity()
            ?: emptyList(),
        snowPack = this.currentForecast?.forecast?.recentObservations?.en?.parseToSnowpackString()
                       ?: "",
        weather = this.currentForecast?.forecast?.weatherForecast?.en ?: "",
        issuedAt = IssuedAtEntity(
            time = time.format(displayFormatter),
            validTo = validTo.format(displayFormatter),
            forecaster = this.currentForecast?.forecast?.forecaster?.name ?: "MG"
        )
    )
}

fun HazardRatingsResponse.toEntity() = HazardRatingEntity(
    highAlpine = this.highAlpine?.value ?: "",
    alpine = this.alpine?.value ?: "",
    subAlpine = this.subAlpine?.value ?: "",
    overAll = this.overall?.value ?: ""
)

fun String.toListOfRecentAvalancheEntity(): List<RecentAvalancheEntity> = parseAvalancheData(this)

fun String.parseToSnowpackString(): String = parseSnowPackData(this)


fun List<AvalancheProblemResponse>.toEntity() = this.map { it.toEntity() }
fun AvalancheProblemResponse.toEntity(): AvalancheProblemEntity {
    return AvalancheProblemEntity(
        aspectElevationChart = this.aspectElevationChart ?: "",
        confidence = confidence ?: "",
        description = this.description?.en ?: "",
        distribution = this.distribution ?: "",
        kind = convertToTitleCase(this.kind ?: ""),
        probability = this.probability ?: "",
        sensitivity = this.sensitivity ?: "",
        size = this.size ?: 0,
        timeOfDay = this.timeOfDay ?: "",
        trend = this.trend ?: ""
    )
}

fun convertToTitleCase(input: String): String {
    return input.split("-")
        .joinToString(" ") { it.capitalize() }
}

fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun AssBulletinEntity.toDomain(): AssBulletin {
    return AssBulletin(
        id = this.id,
        avalancheProblems = this.avalancheProblems.toAvalancheProblemDomainDomain(),
        mainDescription = this.mainDescription,
        hazardRatings = this.hazardRatings.toDomain(),
        recentAvalanches = this.recentAvalanches.toRecentAvalancheDomain(),
        snowPack = this.snowPack,
        weather = this.weather,
        bulletinMetadata = this.issuedAt.toDomain()
    )
}

fun List<AvalancheProblemEntity>.toAvalancheProblemDomainDomain(): List<AvalancheProblem> = this.map { it.toDomain() }
fun List<RecentAvalancheEntity>.toRecentAvalancheDomain(): List<RecentAvalanche> = this.map { it.toDomain() }
fun RecentAvalancheEntity.toDomain(): RecentAvalanche {
    return RecentAvalanche(
        date = this.date,
        size = this.size,
        aspect = this.aspect,
        elevation = this.elevation,
        triggeredBy = this.triggeredBy,
        type = this.type,
        description = this.description
    )
}

fun AvalancheProblemEntity.toDomain(): AvalancheProblem {
    return AvalancheProblem(
        aspectElevationChart = this.aspectElevationChart,
        confidence = this.confidence,
        description = this.description,
        distribution = this.distribution,
        kind = this.kind,
        probability = this.probability,
        sensitivity = this.sensitivity,
        size = this.size,
        timeOfDay = this.timeOfDay,
        trend = this.trend
    )
}

fun HazardRatingEntity.toDomain(): HazardRatings {
    return HazardRatings(
        highAlpine = this.highAlpine,
        alpine = this.alpine,
        subAlpine = this.subAlpine,
        overAll = this.overAll
    )
}

fun IssuedAtEntity.toDomain(): BulletinMetadata {
    return BulletinMetadata(
        time = this.time,
        validTo = this.validTo,
        forecaster = this.forecaster
    )
}
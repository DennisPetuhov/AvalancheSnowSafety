package com.ass.bulletin.domain.models

data class AssBulletin(
    val id: Int,
    val avalancheProblems: List<AvalancheProblem>,
    val mainDescription: String,
    val hazardRatings: HazardRatings,
    val recentAvalanches: List<RecentAvalanche>,
    val snowPack : String,
    val weather: String,
    val bulletinMetadata: BulletinMetadata
)

data class RecentAvalanche(
    val date: String,
    val size: String,
    val aspect: List<String>,
    val elevation: String,
    val triggeredBy: String,
    val type: String,
    val description: String
)

data class AvalancheProblem(
    val aspectElevationChart: String = "",
    val confidence: String = "",
    val description: String = "",
    val distribution: String = "",
    val kind: String = "",
    val probability: String = "",
    val sensitivity: String = "",
    val size: Int = 0,
    val timeOfDay: String = "",
    val trend: String = ""
)

data class HazardRatings(
    val highAlpine: String,
    val alpine: String,
    val subAlpine: String,
    val overAll: String
) {
    companion object {
        val EMPTY = HazardRatings(
            highAlpine = "no rating",
            subAlpine = "no rating",
            alpine = "no rating",
            overAll = "no rating"
        )
    }
}

data class BulletinMetadata(val time: String, val validTo: String, val forecaster: String) {
    companion object {
        val EMPTY = BulletinMetadata(time = "", validTo = "", forecaster = "")
    }
}
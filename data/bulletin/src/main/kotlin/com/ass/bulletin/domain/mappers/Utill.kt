package com.ass.bulletin.domain.mappers

import com.ass.core.storage.entity.RecentAvalancheEntity
import java.util.regex.Pattern

fun parseAvalancheData(input: String): List<RecentAvalancheEntity> {
    val avalanchePattern = Pattern.compile(
        """Date: (\w+ \d+), size: (\d+), aspect: \[([^]]+)], elevation: ([^,]+), triggered by: ([^,]+), type: ([^,]+), description: ([^\n]*)""")


    val avalanches = mutableListOf<RecentAvalancheEntity>()
    val matcher = avalanchePattern.matcher(input)

    while (matcher.find()) {
        val date = matcher.group(1) ?: ""
        val size = matcher.group(2) ?: ""
        val aspect = matcher.group(3).split(",").map { it.trim() }
        val elevation = matcher.group(4) ?: ""
        val triggeredBy = matcher.group(5) ?: ""
        val type = matcher.group(6) ?: ""
        val description = matcher.group(7) ?: ""

        avalanches.add(
            RecentAvalancheEntity(
                date = date,
                size = size,
                aspect = aspect,
                elevation = elevation,
                triggeredBy = triggeredBy,
                type = type,
                description = description
            )
        )
    }

    return avalanches
}


fun parseSnowPackData(input: String, wordIamLooking: String = "Snowpack:"): String {
    val index = input.indexOf(wordIamLooking)
    return if (index != -1) {
        input.substring(index + wordIamLooking.length).replace(Regex("\\s+"), " ")
    } else {
        ""
    }
}
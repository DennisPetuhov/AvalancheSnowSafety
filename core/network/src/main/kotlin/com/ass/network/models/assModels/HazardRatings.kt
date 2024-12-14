package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class HazardRatings(
    @SerialName("alpine")
    val alpine: Alpine?,
    @SerialName("high-alpine")
    val highAlpine: HighAlpine?,
    @SerialName("overall")
    val overall: Overall?,
    @SerialName("sub-alpine")
    val subAlpine: SubAlpine?,
)
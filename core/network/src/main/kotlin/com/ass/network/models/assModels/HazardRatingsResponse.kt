package com.ass.network.models.assModels

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class HazardRatingsResponse(
    @SerialName("alpine")
    val alpine: Alpine??=null,
    @SerialName("high-alpine")
    val highAlpine: HighAlpine??=null,
    @SerialName("overall")
    val overall: Overall??=null,
    @SerialName("sub-alpine")
    val subAlpine: SubAlpine??=null,
)
package com.ass.network.api

import com.ass.network.models.AssResponse
import de.jensklingenberg.ktorfit.http.GET

interface AssApi {
    @GET("json")
    suspend fun fetchData(): AssResponse

    companion object {
        const val baseUrl = "https://avalanche.ge/"
    }
}
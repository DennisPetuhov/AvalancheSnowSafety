package com.ass.network.api

import de.jensklingenberg.ktorfit.http.GET

interface AssApi {
    @GET("api")
    suspend fun fetchData()

    companion object {
        //        const val baseUrl = "https://run.mocky.io/v3/"
        const val baseUrl = "https://rickandmortyapi.com/"
    }
}
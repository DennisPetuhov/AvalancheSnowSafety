package com.ass.network.di

import com.ass.network.api.AssApi
import com.ass.network.api.createAssApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

fun networkModule() = module {
    single { CoroutineScope(Dispatchers.Default + SupervisorJob()) }
    ktorFit()

}

private fun Module.ktorFit() {
    single { provideJson() }
    single { provideClient(json = get()) }
    single { provideAssApi(ktorFit = get()) }

}

fun provideJson() = Json { isLenient = true; ignoreUnknownKeys = true }
fun provideClient(json: Json, enableNetworkLogs: Boolean = false): Ktorfit {
    val client = HttpClient(CIO) {
        defaultRequest { url(AssApi.baseUrl) }
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
                coerceInputValues = true
            })
        }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
    return Ktorfit.Builder().httpClient(client).build()
}

fun provideAssApi(ktorFit: Ktorfit): AssApi {
    return ktorFit.createAssApi()
}
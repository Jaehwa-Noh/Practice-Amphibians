package com.example.myapplication.network

import com.example.myapplication.data.AmphibiansApi
import com.example.myapplication.model.AmphibiansInfoApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json
import javax.inject.Inject


class AmphibiansKtorApiService @Inject constructor() : AmphibiansApi {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            register(
                ContentType.Text.Plain,
                KotlinxSerializationConverter(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            )
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "android-kotlin-fun-mars-server.appspot.com/"
            }
        }
        expectSuccess = true
    }

    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        val httpResponse = try {
            client.get {
                url {
                    path("amphibians")
                }
            }
        } catch (cause: ResponseException) {
            throw cause
        }

        return httpResponse.body<List<AmphibiansInfoApiModel>>()
    }
}
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
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AmphibiansKtorApiService @Inject constructor() : AmphibiansApi {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "https://android-kotlin-fun-mars-server.appspot.com/"
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
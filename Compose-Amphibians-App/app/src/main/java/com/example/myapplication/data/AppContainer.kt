package com.example.myapplication.data

import com.example.myapplication.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibiansInfoRepository: AmphibiansInfoRepository
}


class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val amphibiansApi: AmphibiansApi by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    private val amphibiansRemoteDataSource: AmphibiansRemoteDataSource by lazy {
        AmphibiansRemoteDataSource(
            amphibiansApi,
            Dispatchers.IO
        )
    }

    override val amphibiansInfoRepository: AmphibiansInfoRepository by lazy {
        NetworkAmphibiansInfoRepository(amphibiansRemoteDataSource)
    }
}
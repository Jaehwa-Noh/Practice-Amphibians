package com.example.myapplication.di

import com.example.myapplication.data.AmphibiansApi
import com.example.myapplication.network.AmphibiansApiService
import com.example.myapplication.network.AmphibiansKtorApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RetrofitApi

@Qualifier
annotation class KtorApi

@Module
@InstallIn(SingletonComponent::class)
object AmphibiansApiModule {

    @KtorApi
    @Provides
    @Singleton
    fun provideKtorAmphibiansApi(): AmphibiansApi {
        return AmphibiansKtorApiService()
    }

    @RetrofitApi
    @Provides
    @Singleton
    fun provideAmphibiansApi(): AmphibiansApi {
        val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()

        val amphibiansApi: AmphibiansApi by lazy {
            retrofit.create(AmphibiansApiService::class.java)
        }
        return amphibiansApi
    }
}



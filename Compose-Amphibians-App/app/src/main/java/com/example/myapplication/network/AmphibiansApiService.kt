package com.example.myapplication.network

import com.example.myapplication.data.AmphibiansApi
import com.example.myapplication.model.AmphibiansInfoApiModel
import retrofit2.http.GET

abstract class AmphibiansApiService : AmphibiansApi {
    @GET("amphibians")
    abstract override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel>
}

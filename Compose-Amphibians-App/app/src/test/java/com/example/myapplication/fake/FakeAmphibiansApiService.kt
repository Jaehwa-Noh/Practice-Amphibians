package com.example.myapplication.fake

import com.example.myapplication.data.AmphibiansApi
import com.example.myapplication.model.AmphibiansInfoApiModel

class FakeAmphibiansApiService: AmphibiansApi {
    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        return FakeAmphibiansDataSource.getAmphibiansInfo
    }
}
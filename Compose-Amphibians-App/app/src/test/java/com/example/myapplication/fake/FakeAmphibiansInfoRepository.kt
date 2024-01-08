package com.example.myapplication.fake

import com.example.myapplication.data.AmphibiansInfoRepository
import com.example.myapplication.model.AmphibiansInfoApiModel

class FakeAmphibiansInfoRepository : AmphibiansInfoRepository {
    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        return FakeAmphibiansDataSource.getAmphibiansInfo
    }
}
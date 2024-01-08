package com.example.myapplication.data

import com.example.myapplication.model.AmphibiansInfoApiModel

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel>
}

class NetworkAmphibiansInfoRepository(
    private val amphibiansDataSource : AmphibiansRemoteDataSource
) : AmphibiansInfoRepository {
    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        return amphibiansDataSource.getAmphibiansInfo()
    }
}
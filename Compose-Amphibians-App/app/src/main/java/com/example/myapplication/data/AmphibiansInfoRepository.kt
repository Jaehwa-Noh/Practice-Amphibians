package com.example.myapplication.data

import com.example.myapplication.model.AmphibiansInfoAPIModel

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoAPIModel>
}

class NetworkAmphibiansInfoRepository(
    private val amphibiansApi: AmphibiansApi
) : AmphibiansInfoRepository {
    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoAPIModel> {
        return amphibiansApi.getAmphibiansInfo()
    }
}
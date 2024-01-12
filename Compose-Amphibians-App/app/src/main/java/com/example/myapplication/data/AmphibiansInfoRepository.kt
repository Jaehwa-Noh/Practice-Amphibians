package com.example.myapplication.data

import com.example.myapplication.model.AmphibiansInfoApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel>
}

@Singleton
class NetworkAmphibiansInfoRepository @Inject constructor(
    private val amphibiansDataSource: AmphibiansRemoteDataSource
) : AmphibiansInfoRepository {
    override suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        return amphibiansDataSource.getAmphibiansInfo()
    }
}
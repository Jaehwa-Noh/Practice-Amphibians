package com.example.myapplication.data

import com.example.myapplication.model.AmphibiansInfoAPIModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AmphibiansRemoteDataSource(
    private val amphibiansAPI: AmphibiansApi,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoAPIModel> {
        return withContext(ioDispatcher) {
            amphibiansAPI.getAmphibiansInfo()
        }
    }
}

interface AmphibiansApi {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoAPIModel>
}
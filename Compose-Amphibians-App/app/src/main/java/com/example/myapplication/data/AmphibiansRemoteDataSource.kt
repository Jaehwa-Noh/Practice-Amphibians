package com.example.myapplication.data

import com.example.myapplication.di.KtorApi
import com.example.myapplication.di.RetrofitApi
import com.example.myapplication.model.AmphibiansInfoApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmphibiansRemoteDataSource @Inject constructor(
    @RetrofitApi private val amphibiansAPI: AmphibiansApi,
    @KtorApi private val amphibiansKtorAPI: AmphibiansApi,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel> {
        return withContext(ioDispatcher) {
            amphibiansKtorAPI.getAmphibiansInfo()
        }
    }
}

interface AmphibiansApi {
    suspend fun getAmphibiansInfo(): List<AmphibiansInfoApiModel>
}
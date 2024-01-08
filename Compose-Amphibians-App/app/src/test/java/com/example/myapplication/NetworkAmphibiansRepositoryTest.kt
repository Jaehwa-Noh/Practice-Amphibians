package com.example.myapplication

import com.example.myapplication.data.AmphibiansRemoteDataSource
import com.example.myapplication.data.NetworkAmphibiansInfoRepository
import com.example.myapplication.fake.FakeAmphibiansApiService
import com.example.myapplication.fake.FakeAmphibiansDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansRepositoryTest {

    @Test
    fun networkAmphibiansRepository_GetAmphibiansInfo_VerifyAmphibiansList() {
        runTest {
            val repository = NetworkAmphibiansInfoRepository(
                amphibiansDataSource = AmphibiansRemoteDataSource(
                    FakeAmphibiansApiService(),
                    ioDispatcher = Dispatchers.IO
                )
            )

            assertEquals(
                FakeAmphibiansDataSource.getAmphibiansInfo,
                repository.getAmphibiansInfo()
            )
        }
    }
}
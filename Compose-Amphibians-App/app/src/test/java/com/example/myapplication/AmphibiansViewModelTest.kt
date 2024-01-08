package com.example.myapplication

import com.example.myapplication.fake.FakeAmphibiansDataSource
import com.example.myapplication.fake.FakeAmphibiansInfoRepository
import com.example.myapplication.rules.TestDispatcherRule
import com.example.myapplication.ui.AmphibiansUiState
import com.example.myapplication.ui.AmphibiansViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {
    private lateinit var amphibiansViewModel: AmphibiansViewModel

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Before
    fun createAmphibiansViewModel() {
        runTest {
            amphibiansViewModel =
                AmphibiansViewModel(amphibiansInfoRepository = FakeAmphibiansInfoRepository())
        }
    }

    @Test
    fun amphibiansViewModel_GetAmphibiansInfo_GetAmphibiansListSuccess() {
        assertEquals(
            AmphibiansUiState.Success(FakeAmphibiansDataSource.getAmphibiansInfo),
            amphibiansViewModel.amphibiansUiState.value
        )
    }

}
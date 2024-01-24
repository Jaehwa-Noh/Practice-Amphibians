package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.AmphibiansInfoRepository
import com.example.myapplication.model.AmphibiansInfoApiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.plugins.ResponseException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AmphibiansViewModel @Inject constructor(
    val amphibiansInfoRepository: AmphibiansInfoRepository
) : ViewModel() {

    private var _amphibiansUiState: MutableStateFlow<AmphibiansUiState> =
        MutableStateFlow(AmphibiansUiState.Loading)
    val amphibiansUiState: StateFlow<AmphibiansUiState> = _amphibiansUiState.asStateFlow()

    init {
        getAmphibiansList()
    }

    fun getAmphibiansList() {
        viewModelScope.launch {
            _amphibiansUiState.value = AmphibiansUiState.Loading
            _amphibiansUiState.value = try {
                AmphibiansUiState.Success(amphibians = amphibiansInfoRepository.getAmphibiansInfo())
            } catch (e: IOException) {
                AmphibiansUiState.Error(e.localizedMessage ?: "")
            } catch (e: ResponseException) {
                AmphibiansUiState.Error(e.localizedMessage ?: "")
            }
        }
    }
}


sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<AmphibiansInfoApiModel>) : AmphibiansUiState
    data class Error(val errorMessage: String) : AmphibiansUiState
    data object Loading : AmphibiansUiState
}
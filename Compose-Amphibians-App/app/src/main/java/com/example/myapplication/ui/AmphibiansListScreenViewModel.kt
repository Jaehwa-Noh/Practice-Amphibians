package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.AmphibiansApplication
import com.example.myapplication.data.AmphibiansInfoRepository
import com.example.myapplication.model.AmphibiansInfoApiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AmphibiansListScreenViewModel(
    private val amphibiansInfoRepository: AmphibiansInfoRepository
) : ViewModel() {

    private var _amphibiansUiState: MutableStateFlow<AmphibiansUiState> =
        MutableStateFlow(AmphibiansUiState.Loading)
    val amphibiansUiState: StateFlow<AmphibiansUiState> = _amphibiansUiState.asStateFlow()

    init {
        getAmphibiansList()
    }

    private fun getAmphibiansList() {
        viewModelScope.launch {
            _amphibiansUiState.value = AmphibiansUiState.Loading
            _amphibiansUiState.value = try {
                AmphibiansUiState.Success(amphibians = amphibiansInfoRepository.getAmphibiansInfo())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansInfoRepository = application.container.amphibiansInfoRepository
                AmphibiansListScreenViewModel(amphibiansInfoRepository = amphibiansInfoRepository)
            }
        }
    }

}


sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<AmphibiansInfoApiModel>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}
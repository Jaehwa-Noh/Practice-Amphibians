package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    val amphibiansViewModel: AmphibiansViewModel =
        viewModel(factory = AmphibiansViewModel.Factory)
    val amphibiansUiState = amphibiansViewModel.amphibiansUiState.collectAsState()

    when (amphibiansUiState.value) {
        is AmphibiansUiState.Error -> ErrorScreen(
            modifier = modifier,
            errorMessage = (amphibiansUiState.value as AmphibiansUiState.Error).errorMessage,
            onRetryClick = {
                amphibiansViewModel.getAmphibiansList()
            })

        is AmphibiansUiState.Loading -> LoadingScreen(
            modifier = modifier
                .testTag("Progress")
        )

        is AmphibiansUiState.Success -> AmphibiansListScreen(
            modifier = modifier,
            amphibiansList = (amphibiansUiState.value as AmphibiansUiState.Success).amphibians
        )
    }

}

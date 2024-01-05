package com.example.myapplication.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    AmphibiansListScreen(
        modifier = modifier
            .fillMaxSize()
    )
}

package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import com.example.myapplication.model.AmphibiansInfoApiModel

@Composable
fun AmphibiansListScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(emptyList<AmphibiansInfoApiModel>()) {
            AmphibiansListItem(amphibian = it)
        }
    }
}

@Composable
fun AmphibiansListItem(
    modifier: Modifier = Modifier,
    amphibian: AmphibiansInfoApiModel
) {
    Card(modifier = modifier) {
        Text(text = "${amphibian.name}(${amphibian.type}")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Text(text = amphibian.description)
    }
}
package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.AmphibiansInfoApiModel

@Composable
fun AmphibiansListScreen(
    modifier: Modifier = Modifier,
    amphibiansList: List<AmphibiansInfoApiModel>
) {

    LazyColumn(modifier = modifier) {
        items(amphibiansList) {
            AmphibiansListItem(
                amphibian = it,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AmphibiansListItem(
    modifier: Modifier = Modifier,
    amphibian: AmphibiansInfoApiModel
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${amphibian.name}(${amphibian.type})",
                style = MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Text(text = amphibian.description)
        }
    }
}
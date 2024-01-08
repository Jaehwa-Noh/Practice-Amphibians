package com.example.myapplication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
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
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentSize()
                    )
                },
                error = {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_broken_image_24px),
                            contentDescription = "Error",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .testTag(amphibian.name),
                contentScale = ContentScale.Crop
            )
            Text(text = amphibian.description)
        }
    }
}
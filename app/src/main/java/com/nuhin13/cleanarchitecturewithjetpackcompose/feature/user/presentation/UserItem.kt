package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun UserItem(description: String, imageLink: String) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Gray, Color.Transparent),
        start = Offset(20f, 100f),
        end = Offset(500f, 700f)
    )

    Box(
        modifier = Modifier
            .height(200.dp)
            .clip(RoundedCornerShape(6.dp))
    ) {

        SubcomposeAsyncImage(
            model = imageLink,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(brush = gradient)
        ) {
            Text(
                text = description,
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    UserItem(
        description = "This is a description",
        imageLink = "https://picsum.photos/300/300"
    )
}
package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.domain.feature.post.entity.Owner

@Composable
fun UserSection(owner: Owner) {
    Text(
        text = "Owner Info",
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            SubcomposeAsyncImage(
                model = owner.profilePic,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
            )

            Text(
                text = owner.fullName,
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 16.dp, end = 10.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
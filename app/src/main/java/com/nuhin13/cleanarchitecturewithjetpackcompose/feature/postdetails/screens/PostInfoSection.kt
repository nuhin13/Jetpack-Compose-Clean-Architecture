package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.domain.feature.post.entity.PostItem

@Composable
fun PostInfoSection(postInfo: PostItem) {
    Text(
        text = "Post Info",
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) {
            SubcomposeAsyncImage(
                model = postInfo.imageLink,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = postInfo.description ?: "",
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = postInfo.publishDate,
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.like_svg),
                        contentDescription = "Circular Image",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = postInfo.likeCount.toString(),
                    )
                }
            }
        }
    }
}
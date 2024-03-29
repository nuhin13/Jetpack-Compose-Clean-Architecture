package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.domain.feature.post.entity.PostItem

@Composable
fun PostItemSection(postItem: PostItem, onClick: (String) -> Unit) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Gray, Color.Transparent),
        start = Offset(20f, 100f),
        end = Offset(500f, 700f)
    )

    Box(
        modifier = Modifier
            .height(250.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onClick(postItem.imageLink ?: "")
            },
    ) {

        SubcomposeAsyncImage(
            model = postItem.imageLink,
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
                text = postItem.description ?: "",
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(modifier = Modifier.padding(10.dp)) {
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
                    text = postItem.likeCount.toString(),
                )
            }
        }

        SubcomposeAsyncImage(
            model = postItem.owner?.profilePic,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .height(40.dp)
                .width(40.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    /*PostItem(
        description = "This is a description",
        imageLink = "https://picsum.photos/300/300",
        likeCount = "100",
        ownerImage = "https://picsum.photos/300/300",
        onClick = {}
    )*/
}
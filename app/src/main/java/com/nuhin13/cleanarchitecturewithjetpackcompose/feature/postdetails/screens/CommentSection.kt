package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.vm.PostDetailsViewModel
import com.nuhin13.domain.feature.post.entity.PostComment

@Composable
fun CommentItemListSection(
    postId: String,
    postViewModel: PostDetailsViewModel = hiltViewModel()
) {

    val postList = postViewModel.comments.collectAsState()
    val itemsList = postList.value

    LaunchedEffect(Unit) {
        postViewModel.fetchPostCommentList(postId)
    }

    Text(
        text = "Comment List",
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
        )
    )

    LazyHorizontalGrid(
        modifier = Modifier.height(100.dp),
        contentPadding = PaddingValues(1.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        rows = GridCells.Fixed(1),
    ) {
        items(itemsList.total) { item ->
            CommentItemSection(itemsList.comments[item])
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun CommentItemSection(comment: PostComment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
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
                model = comment.owner.profilePic,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = comment.message,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = comment.publishDate,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}
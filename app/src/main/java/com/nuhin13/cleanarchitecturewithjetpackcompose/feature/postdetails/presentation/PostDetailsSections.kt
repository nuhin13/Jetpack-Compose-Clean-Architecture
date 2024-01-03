package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.domain.PostDetailsViewModel

data class PostInfo(
    val description: String,
    val imageLink: String,
    val likeCount: String,
    val tags: ArrayList<String>,
    val publishDate: String,
)

data class Owner(
    val name: String,
    val proPic: String,
)

data class CommentSection(
    val comments: ArrayList<Comment>,
    val total: String,
)

data class Comment(
    val message: String,
    val publishDate: String,
    val owner: Owner,
)

@Composable
fun PostSection(postInfo: PostInfo) {

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
                    text = postInfo.description,
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
                        text = postInfo.likeCount,
                    )
                }
            }
        }
    }
}

@Composable
fun UserSection(owner: Owner) {

    Text(
        text = "Owner Info",
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
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
                model = owner.proPic,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
            )

            Text(
                text = owner.name,
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

@Composable
fun PostItem(description: String, imageLink: String, likeCount: String, ownerImage: String) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Gray, Color.Transparent),
        start = Offset(20f, 100f),
        end = Offset(500f, 700f)
    )

    Box(
        modifier = Modifier
            .height(250.dp)
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
                    text = likeCount,
                )
            }
        }

        SubcomposeAsyncImage(
            model = ownerImage,
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

@Composable
fun CommentItemList(postId:String,
                    postViewModel: PostDetailsViewModel = hiltViewModel()) {

    val postList = postViewModel.commentResponse.collectAsState()
    val itemsList = postList.value?: arrayListOf()

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
        items(itemsList) { item ->
            val comment =  Comment(
                message = item.message?:"",
                publishDate = item.publishDate?:"",
                owner = Owner(
                    name = item.owner.title + " " + item.owner.firstName + " " + item.owner.lastName,
                    proPic = item.owner.picture?:"https://picsum.photos/300/300"
                )
            )

            CommentItem(comment)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
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
                model = comment.owner.proPic,
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

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {

//    val postInfo = PostInfo(
//        description = "This is a description",
//        imageLink = "https://picsum.photos/300/300",
//        likeCount = "100",
//        tags = arrayListOf("tag1", "tag2", "tag3"),
//        publishDate = "12/12/12"
//    )
//
//    PostSection(postInfo)


//    val userInfo = Owner(
//        name = "Nuhin",
//        proPic = "https://picsum.photos/300/300"
//    )
//
//    UserSection(userInfo)

//    val comment =  Comment(
//            message = "This is a comment",
//            publishDate = "12/12/12",
//            owner = Owner(
//                name = "Nuhin",
//                proPic = "https://picsum.photos/300/300"
//            )
//    )
//
//    CommentItem(comment)


//    CommentItemList()

}
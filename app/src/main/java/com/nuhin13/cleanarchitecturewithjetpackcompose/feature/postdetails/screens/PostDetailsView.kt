package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.domain.feature.post.entity.PostItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailsView(navController: NavHostController,
                    postModel: PostItem) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.post_details))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            PostInfoSection(postModel)

            UserSection(postModel.owner ?: error("Owner is null"))

            CommentItemListSection(postId = postModel.id)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostDetailsPreview() {
    //PostDetailsView(navController = NavHostController(LocalContext.current))
}

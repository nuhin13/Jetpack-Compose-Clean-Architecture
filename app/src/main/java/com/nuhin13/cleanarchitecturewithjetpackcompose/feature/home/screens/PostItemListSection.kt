package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm.PostViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.PostDetailsScreen

@Composable
fun PostItemListSection(navController: NavHostController, postViewModel: PostViewModel) {

    val postList = postViewModel.postResponse.collectAsState()
    val itemsList = postList.value

    LaunchedEffect(Unit) {
        postViewModel.fetchPostList()
    }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(itemsList.postList) { item ->
            PostItemSection(
                postItem = item,
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("post_item", item)
                    //navController.navigate(PostDetailsScreen.route + "/${item.id}" )
                    navController.navigate(PostDetailsScreen.route)
                }
            )

            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemListPreview() {
    //PostItemList()
}
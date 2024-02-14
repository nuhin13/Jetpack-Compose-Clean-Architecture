package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm.PostViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.PostDetailsScreen
import com.nuhin13.domain.util.DataStatus

@Composable
fun PostItemListSection(navController: NavHostController, postViewModel: PostViewModel) {

    val state = postViewModel.uiState.collectAsState()
    val itemsList = state.value.postList
    val status = state.value.status

    LaunchedEffect(Unit) {
        postViewModel.fetchPostList()
    }

    when (status) {
        DataStatus.LOADING -> {
            CircularProgressIndicator(progress = 0.5f)

//            Column(
//                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                CircularProgressIndicator(
//                    modifier = Modifier.padding(16.dp),
//                    color = colorResource(id = R.color.purple_200),
//                    strokeWidth = Dp(value = 4F)
//                )
//            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(top = 30.dp),
//                contentAlignment = Alignment.Center
//            ) {
//
//                // progressbar in jetpack compose
//                CircularProgressIndicator(
//                    modifier = Modifier.width(70.dp),
//                    color = MaterialTheme.colorScheme.secondary,
//                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
//                )
//            }
        }

        DataStatus.SUCCESS -> {
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
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                "post_item",
                                item
                            )
                            //navController.navigate(PostDetailsScreen.route + "/${item.id}" )
                            navController.navigate(PostDetailsScreen.route)
                        }
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }

        else -> {
            Text(text = "Error occurred!")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PostItemListPreview() {
    //PostItemList()
}
package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.presentation

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.domain.PostViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.domain.UserViewModel

@Composable
fun UserItemList() {

    val postViewModel = UserViewModel()

    LaunchedEffect(Unit) {
        postViewModel.fetchUserList()
    }

    val itemsList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(itemsList) { item ->
            UserItem(
                description = "This is a description",
                imageLink = "https://picsum.photos/300/300"
            )

            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemListPreview() {
    UserItemList()
}
package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.vm.UserViewModel

@Composable
fun UserItemListSection(userViewModel: UserViewModel = hiltViewModel()) {

    val userList = userViewModel.userList.collectAsState()
    val itemsList = userList.value.ownerList

    LaunchedEffect(Unit) {
        userViewModel.fetchUserList()
    }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(itemsList.size) { item ->
            UserItemSection(owner = itemsList[item])
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemListPreview() {
    UserItemListSection()
}
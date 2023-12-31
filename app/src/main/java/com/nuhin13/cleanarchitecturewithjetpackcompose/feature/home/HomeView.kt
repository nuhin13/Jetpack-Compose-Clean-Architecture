package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeView(navController: NavHostController) {
    Column {
        Text(text = "This is Home View")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Log out")
        }

        PostItemList()

        PostItem(
            description = "This is a description",
            imageLink = "https://picsum.photos/300/300",
            likeCount = "100",
            ownerImage = "https://picsum.photos/300/300"
        )
    }
}

@Preview
@Composable
fun HomeViewPreview() {

}

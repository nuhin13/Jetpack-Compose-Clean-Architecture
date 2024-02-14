package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm.PostViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.UserListScreen

@Composable
fun HomeView(navController: NavHostController, postViewModel: PostViewModel = hiltViewModel()) {

    Column {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
        ) {
            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(UserListScreen.route)
                    },
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_circle_svg),
                    contentDescription = "Circular Image",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(CircleShape)
                )
            }

            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(10.dp)
                    .clickable { },
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logout_svg),
                    contentDescription = "Circular Image",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(CircleShape)
                )
            }
        }

        PostItemListSection(navController = navController, postViewModel = postViewModel)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeViewPreview() {
//    HomeView(navController = NavHostController(LocalContext.current))
//}

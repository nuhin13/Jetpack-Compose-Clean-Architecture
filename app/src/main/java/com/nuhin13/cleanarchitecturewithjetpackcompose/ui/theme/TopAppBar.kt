package com.nuhin13.cleanarchitecturewithjetpackcompose.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.R

@Composable
fun TopAppBar(titleText :String, navHostController: NavHostController) {
    /*TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.user_list))
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
    )*/
}
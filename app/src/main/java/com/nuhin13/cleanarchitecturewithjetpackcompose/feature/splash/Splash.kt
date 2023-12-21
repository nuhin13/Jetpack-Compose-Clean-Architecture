package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.ConstantData
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.random
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.LoginScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(navHostController: NavHostController) {

    val imageUrl = ConstantData.imageList[random()]

    SubcomposeAsyncImage(
        model = imageUrl,
        //placeholder = painterResource(R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(70.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

    LaunchedEffect(Unit) {
        delay(3.seconds)

        navHostController.navigate(LoginScreen.route) {
            popUpTo(SplashScreen.route) {
                inclusive = true
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen(navHostController = NavHostController(context = LocalContext.current))
}




package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.screens.HomeView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.screens.LoginView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.registration.screens.RegistrationView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.screens.PostDetailsView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.splash.SplashView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.screens.UserListView
import com.nuhin13.domain.feature.post.entity.PostItem

@Composable
fun SetupNavGraph (windowSize: WindowSize, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = SplashScreen.route
    ) {
        composable(route = SplashScreen.route) {
            SplashView(navHostController = navController)
        }
        composable(route = LoginScreen.route) {
            LoginView(navController = navController)
        }
        composable(route = RegistrationScreen.route) {
            RegistrationView(navController = navController)
        }
        composable(route = HomeScreen.route) {
            HomeView(navController = navController)
        }
        composable(route = UserListScreen.route) {
            UserListView(navController = navController)
        }

        composable(
            route = PostDetailsScreen.route,
        ) {
            //var userObject: PostApiModel? = null

            //LaunchedEffect(key1 = it) {
            val userObject = navController.previousBackStackEntry?.savedStateHandle?.get<PostItem>("post_item")

            userObject?.let {
                PostDetailsView(
                    navController = navController,
                    postModel = it
                )
            }
            //}
        }
    }
}
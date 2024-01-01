package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.HomeView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.LoginView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.RegistrationView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.splash.SplashView
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.presentation.UserListView

@Composable
fun SetupNavGraph(windowSize: WindowSize, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen.route
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
    }
}
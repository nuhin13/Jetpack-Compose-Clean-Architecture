package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.LoginScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.RegistrationScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.splash.SplashScreen

@Composable
fun SetupNavGraph(windowSize: WindowSize, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen.route
    ) {
        composable(route = SplashScreen.route) {
            SplashScreen(navHostController = navController)
        }
        composable(route = LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
    }
}
package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation

sealed class Screens(val route: String)
data object LoginScreen : Screens("login_screen")
data object RegistrationScreen : Screens("registration_screen")
data object SplashScreen : Screens("splash_screen")
data object HomeScreen : Screens("home_screen")
data object UserListScreen : Screens("user_list_screen")
data object PostDetailsScreen : Screens(route = "post_details_screen")
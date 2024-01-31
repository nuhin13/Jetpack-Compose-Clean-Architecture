package com.nuhin13.cleanarchitecturewithjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class UiModule {
//
//    @Composable
//    @Provides
//    @Singleton
//    fun provideNavHost(): NavHostController {
//        return rememberNavController()
//    }
//}
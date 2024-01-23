package com.nuhin13.cleanarchitecturewithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.DummyProjectDatabase
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.SetupNavGraph
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.rememberWindowSize
import com.nuhin13.cleanarchitecturewithjetpackcompose.ui.theme.CleanArchitectureWithJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CleanArchitectureWithJetpackComposeTheme {

                val window = rememberWindowSize()
                val navController = rememberNavController()

                SetupNavGraph(windowSize = window, navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureWithJetpackComposeTheme {
        //Greeting("Android")
    }
}
package com.nuhin13.cleanarchitecturewithjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.DummyProjectDatabase
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.domain.PostViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.SetupNavGraph
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.rememberWindowSize
import com.nuhin13.cleanarchitecturewithjetpackcompose.ui.theme.CleanArchitectureWithJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CleanArchitectureWithJetpackComposeTheme {

                val window = rememberWindowSize()
                val navController = rememberNavController()

                SetupNavGraph(windowSize = window, navController = navController)


                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
//                ) {
//                    //Greeting("Android", db = dummyProjectDatabase)
////                    LoginScreen()
//                //RegistrationScreen()
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, db: DummyProjectDatabase) {

    /*CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default) {

    }*/


    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            //db.userInfoDao.upsert(UserInfo(phoneNumber = "99999", pin = "123", email = "ssss", id = 6))
            //db.userInfoDao.insert(UserInfo(phoneNumber = "00111", pin = "123", email = "ssss", id = 9))
            Log.e("THIS is log", db.userInfoDao.fetchAll().toString())
            Log.e("THIS is log", db.userInfoDao.fetchById(1) .toString())
        }
    }

    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureWithJetpackComposeTheme {
        //Greeting("Android")
    }
}
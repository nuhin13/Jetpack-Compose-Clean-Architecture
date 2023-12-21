package com.nuhin13.cleanarchitecturewithjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.DummyProjectDatabase
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.UserInfo
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.LoginScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.RegistrationScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.ui.theme.CleanArchitectureWithJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private lateinit var dummyProjectDatabase: DummyProjectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dummyProjectDatabase = Room.databaseBuilder(
            this, DummyProjectDatabase::class.java, "DUMMY_DATABASE"
        ).build()

        setContent {
            CleanArchitectureWithJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android", db = dummyProjectDatabase)
//                    LoginScreen()
                RegistrationScreen()
                }
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
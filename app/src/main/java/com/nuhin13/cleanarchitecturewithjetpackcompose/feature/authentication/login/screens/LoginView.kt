package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.ConstantData
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.vm.LoginViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.RegistrationScreen
import com.nuhin13.cleanarchitecturewithjetpackcompose.ui.common.EditTextWidget
import kotlinx.coroutines.launch

@Composable
fun LoginView(navController: NavHostController, loginViewModel: LoginViewModel = hiltViewModel()) {

    val imageUrl = ConstantData.imageList[random()]
    var phone by rememberSaveable { mutableStateOf("") }
    var pin by rememberSaveable { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
         loginViewModel.checkUserLoggedInOrNot(navController)
    }

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Column {
            AsyncImage(
                model = imageUrl,
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Text(
                text = stringResource(id = R.string.login_upper_text),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            EditTextWidget(
                value = phone,
                onValueChange = { phone = it }, label = "Enter Your Phone Number",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            )

            EditTextWidget(
                value = pin,
                onValueChange = { pin = it }, label = "Enter Your Pin",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        loginViewModel.checkValidInput(phone, pin, navController)
                    }
                },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .padding(top = 8.dp, end = 16.dp)
                    .width(100.dp)
                    .align(Alignment.End)
            ) {
                Text(text = stringResource(id =R.string.login))
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 24.dp, end = 16.dp, bottom = 40.dp)
                .weight(1f, false),
        ) {
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.login_new_account)),
                modifier = Modifier.padding(end = 40.dp),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                onClick = {
                    navController.navigate(RegistrationScreen.route)
                }
            )

            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.login_skip)),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                onClick = {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    //LoginScreen()
}

fun random(): Int {
    return (0..13).random()
}



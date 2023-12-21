package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.ConstantData

@Composable
fun LoginScreen() {

    val imageUrl = ConstantData.imageList[random()]
    var phone by rememberSaveable { mutableStateOf("") }
    var pin by rememberSaveable { mutableStateOf("") }

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

            OutlinedTextField(value = phone,
                onValueChange = { phone = it }, label = {
                    Text("Enter Your Phone Number")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            )

            OutlinedTextField(value = pin,
                onValueChange = { pin = it }, label = {
                    Text("Enter Your Pin")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )

            Button(
                onClick = { /*TODO*/ },
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
                .padding(end = 16.dp, bottom = 40.dp)
                .weight(1f, false),
        ) {
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.login_new_account)),
                modifier = Modifier.padding(end = 40.dp),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                onClick = {

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
    LoginScreen()
}

fun random(): Int {
    return (0..14).random()
}


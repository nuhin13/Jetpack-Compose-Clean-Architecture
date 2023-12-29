package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.DatabaseManager
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.UserInfo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationView(navController: NavHostController) {

    var phone by rememberSaveable { mutableStateOf("") }
    var pin by rememberSaveable { mutableStateOf("") }
    var confirmPin by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.login_new_account))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.login_new_account),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            EditTextWidget(
                value = phone,
                onValueChange = { phone = it }, label = "Enter Your Phone Number",
                modifier = commonEditTextModifier
            )

            EditTextWidget(
                value = email,
                onValueChange = { email = it }, label = "Enter Your Email (optional)",
                modifier = commonEditTextModifier
            )

            EditTextWidget(
                value = pin,
                onValueChange = { pin = it }, label = "Enter Your Pin",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = commonEditTextModifier
            )

            EditTextWidget(
                value = confirmPin,
                onValueChange = { confirmPin = it }, label = "Confirm Your Pin",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        checkValidInput(phone, pin, confirmPin, email, context)
                    }
                },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            ) {
                Text(text = stringResource(id = R.string.registration))
            }
        }
    }
}

private suspend fun checkValidInput(
    phone: String, pin: String, confirmPin: String, email: String, context: Context
) {
    if (phone.isEmpty() || pin.isEmpty() || confirmPin.isEmpty()) {
        Toast.makeText(context, "Please Fill the Info", Toast.LENGTH_LONG).show()
        return
    }

    if (pin != confirmPin) {
        Toast.makeText(context, "Password Not Matched", Toast.LENGTH_LONG).show()
        return
    }

    addUser(context, phone, email, pin)
}

private suspend fun addUser(context: Context, phone: String, email: String, pin: String) {
    val userDb = DatabaseManager.getInstance(context).userInfoDao
    userDb.insert(UserInfo(phoneNumber = phone, pin = pin, email = email))

    Toast.makeText(context, "Successfully Added", Toast.LENGTH_LONG).show()
}


@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationView(navController = NavHostController(context = LocalContext.current))
}


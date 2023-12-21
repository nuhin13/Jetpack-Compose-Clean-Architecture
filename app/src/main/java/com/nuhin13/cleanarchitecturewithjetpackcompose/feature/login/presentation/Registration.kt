package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nuhin13.cleanarchitecturewithjetpackcompose.R
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.ConstantData

@Composable
fun RegistrationScreen() {

    var phone by rememberSaveable { mutableStateOf("") }
    var pin by rememberSaveable { mutableStateOf("") }
    var confirmPin by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

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
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.registration))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}

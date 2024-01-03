package com.nuhin13.cleanarchitecturewithjetpackcompose.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EditTextWidget(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(label)
        },
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier

    )
}

val commonEditTextModifier = Modifier
    .fillMaxWidth()
    .padding(bottom = 8.dp)
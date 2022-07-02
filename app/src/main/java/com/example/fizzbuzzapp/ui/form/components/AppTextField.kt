package com.example.fizzbuzzapp.ui.form.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

/**
 * The [AppTextField] composable is a TextField using Material OutlinedTextField.
 **/
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    placeholder: String,
    onChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyBoardActions: KeyboardActions = KeyboardActions(),
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        label = { Text(label) },
        onValueChange = onChange,
        textStyle = MaterialTheme.typography.button,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyBoardActions,
        placeholder = {
            Text(text = placeholder, style = MaterialTheme.typography.button)
        }
    )
}
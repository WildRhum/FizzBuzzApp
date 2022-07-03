package com.example.fizzbuzzapp.ui.form.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fizzbuzzapp.R

/**
 * The [AppTextField] composable is a TextField using Material OutlinedTextField
 * and that bring a Text with it to show error an message if necessary
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
    showError: Boolean = false,
    errorMessage: String = ""
) {
    //val showError = errorMessage.isNotBlank()
    Column {
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
            },
            isError = showError,
            trailingIcon = {
                if (showError) Icon(
                    imageVector = Icons.Filled.Close, contentDescription = stringResource(
                        R.string.text_field_error_icon_content_description
                    )
                )
            }
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = dimensionResource(R.dimen.default_padding))
            )
        }
    }
}
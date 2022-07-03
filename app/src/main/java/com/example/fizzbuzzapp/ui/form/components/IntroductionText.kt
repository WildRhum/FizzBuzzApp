package com.example.fizzbuzzapp.ui.form.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

/**
 * The [IntroductionText] composable is a big text in [MaterialTheme.typography]
 * with h1 typography, centered and that fills the horizontal space
 **/
@Composable
fun IntroductionText(
    text: String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}
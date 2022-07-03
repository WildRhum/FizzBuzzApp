package com.example.fizzbuzzapp.ui.form.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * The [GradientButton] composable is a button with horizontalGradient.
 * It includes rounded corner, padding and centered text
 **/
@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    gradient : Brush =  Brush.horizontalGradient(
        colors = listOf(
            MaterialTheme.colors.secondary,
            MaterialTheme.colors.primary
        )
    ),
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .background(
                    gradient,
                    shape = MaterialTheme.shapes.small
                )
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text)
        }
    }
}
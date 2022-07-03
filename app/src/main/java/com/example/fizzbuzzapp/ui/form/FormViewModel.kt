package com.example.fizzbuzzapp.ui.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor() : ViewModel() {
    var firstNumberInput by mutableStateOf("")
    var secondNumberInput by mutableStateOf("")
    var firstTextInput by mutableStateOf("")
    var secondTextInput by mutableStateOf("")

    var firstNumberInputError by mutableStateOf(false)
    var secondNumberInputError by mutableStateOf(false)
    var firstTextInputError by mutableStateOf(false)
    var secondTextInputError by mutableStateOf(false)

    fun isTextInputInError(input: String): Boolean {
        return input.isBlank()
    }

    fun isNumberInputInError(input: String): Boolean {
        return input.isBlank() || input.toInt() == 0
    }

    fun areInputsValid(): Boolean {
        firstNumberInputError = isTextInputInError(firstNumberInput)
        secondNumberInputError = isTextInputInError(secondNumberInput)
        firstTextInputError = isTextInputInError(firstTextInput)
        secondTextInputError = isTextInputInError(secondTextInput)
        return firstNumberInputError && secondNumberInputError && firstTextInputError && secondTextInputError
    }
}
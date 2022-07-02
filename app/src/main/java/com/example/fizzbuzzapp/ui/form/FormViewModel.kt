package com.example.fizzbuzzapp.ui.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor() : ViewModel() {
    var firstInputNumber by mutableStateOf("")
    var secondInputNumber by mutableStateOf("")
    var firstInputText by mutableStateOf("")
    var secondInputText by mutableStateOf("")
}
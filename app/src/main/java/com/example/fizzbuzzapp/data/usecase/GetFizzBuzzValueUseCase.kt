package com.example.fizzbuzzapp.data.usecase

import com.example.fizzbuzzapp.utils.isDivisibleBy
import javax.inject.Inject

class GetFizzBuzzValueUseCase @Inject constructor() {
    fun perform(
        value: Int,
        firstNumberInput: String,
        secondNumberInput: String,
        firstTextInput: String,
        secondTextInput: String
    ) : String {
        return when {
            value.isDivisibleBy(firstNumberInput.toInt(), secondNumberInput.toInt()) -> firstTextInput + secondTextInput
            value.isDivisibleBy(firstNumberInput.toInt()) -> firstTextInput
            value.isDivisibleBy(secondNumberInput.toInt()) -> secondTextInput
            else -> value.toString()
        }
    }
  
}
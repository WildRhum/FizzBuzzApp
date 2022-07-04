package com.example.fizzbuzzapp.ui.fizzbuzz

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.fizzbuzzapp.data.repository.FizzBuzzRepository
import com.example.fizzbuzzapp.data.usecase.GetFizzBuzzValueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
    private val fizzBuzzRepository: FizzBuzzRepository,
    private val getFizzBuzzValueUseCase: GetFizzBuzzValueUseCase
) : ViewModel() {
    var itemsList = mutableStateListOf<Int>()

    fun fetchMoreItems(fizzBuzzLimit: Int) {
        itemsList.addAll(fizzBuzzRepository.getFizzBuzz(fizzBuzzLimit))
    }

    fun getFizzBuzzValue(
        value: Int,
        firstNumberInput: String,
        secondNumberInput: String,
        firstTextInput: String,
        secondTextInput: String
    ): String {
        return getFizzBuzzValueUseCase.perform(
            value,
            firstNumberInput,
            secondNumberInput,
            firstTextInput,
            secondTextInput
        )
    }
}
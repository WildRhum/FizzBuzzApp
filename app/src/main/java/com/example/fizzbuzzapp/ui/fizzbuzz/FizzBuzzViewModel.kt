package com.example.fizzbuzzapp.ui.fizzbuzz

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.fizzbuzzapp.data.repository.FizzBuzzRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
    private val fizzBuzzRepository: FizzBuzzRepository
) : ViewModel() {
    var itemsList = mutableStateListOf<Int>()

    fun fetchMoreItems(fizzBuzzLimit: Int) {
        itemsList.addAll(fizzBuzzRepository.getFizzBuzz(fizzBuzzLimit))
    }
}
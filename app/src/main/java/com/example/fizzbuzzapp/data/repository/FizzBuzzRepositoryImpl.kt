package com.example.fizzbuzzapp.data.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FizzBuzzRepositoryImpl @Inject constructor() : FizzBuzzRepository {
    // The sequence starts at 1 and goes to fizzBuzzLimit
    private var currentValue: Int = FIZZ_BUZZ_START_VALUE

    override fun getFizzBuzz(fizzBuzzLimit: Int): List<Int> {
        return generateSequence { (currentValue++).takeIf { it <= fizzBuzzLimit } }.take(
            FIZZ_BUZZ_BATCH_SIZE
        ).toList()
    }

    companion object {
        const val FIZZ_BUZZ_BATCH_SIZE = 20
        const val FIZZ_BUZZ_START_VALUE = 1
    }
}
package com.example.fizzbuzzapp

import com.example.fizzbuzzapp.data.usecase.GetFizzBuzzValueUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GetFizzBuzzValueUseCaseTest() {

    private val getFizzBuzzValueUseCase: GetFizzBuzzValueUseCase = GetFizzBuzzValueUseCase()

    @Test
    fun shouldDisplayFizzBuzz() {
        assertEquals(getFizzBuzzValueUseCase.perform(5, "5", "1", "Fizz", "Buzz"), "FizzBuzz")
    }

    @Test
    fun shouldDisplayFizz() {
        assertEquals(getFizzBuzzValueUseCase.perform(5, "5", "10", "Fizz", "Buzz"), "Fizz")
    }

    @Test
    fun shouldDisplayBuzz() {
        assertEquals(getFizzBuzzValueUseCase.perform(1, "5", "1", "Fizz", "Buzz"), "Buzz")
    }

    @Test
    fun edgeCaseValueIs0() {
        assertEquals(getFizzBuzzValueUseCase.perform(0, "5", "1", "Fizz", "Buzz"), "FizzBuzz")
    }
}
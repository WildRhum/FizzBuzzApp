package com.example.fizzbuzzapp.data.repository

interface FizzBuzzRepository {
    fun getFizzBuzz(fizzBuzzLimit: Int): List<Int>
}
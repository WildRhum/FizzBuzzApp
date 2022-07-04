package com.example.fizzbuzzapp.utils

fun Int.isDivisibleBy(vararg divisors: Int) = divisors.all { this % it == 0 }
package com.k7.mealapp

interface Mapper<INPUT, OUTPUT> {
    fun map(input: INPUT): OUTPUT
}
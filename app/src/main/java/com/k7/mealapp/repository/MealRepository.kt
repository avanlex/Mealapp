package com.k7.mealapp.repository


import com.k7.mealapp.model.api.MealAPI

interface MealRepository {

    suspend fun getRandomMeals(): List<MealAPI>

}
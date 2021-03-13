package com.k7.mealapp.repository

import com.k7.mealapp.data.Meal

interface MealRepository {

    suspend fun getRandomMeals(): List<Meal>

}
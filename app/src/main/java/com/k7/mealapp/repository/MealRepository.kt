package com.k7.mealapp.repository


import com.k7.mealapp.model.api.MealAPI
import com.k7.mealapp.models.dto.MealDto

interface MealRepository {

    suspend fun getRandomMeals(): List<MealDto>

}
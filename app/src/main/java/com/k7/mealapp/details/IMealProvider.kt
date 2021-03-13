package com.k7.mealapp.details

import com.k7.mealapp.models.dto.MealDto

interface IMealProvider {
    suspend fun getMeal(mealId: Int): List<MealDto>
}

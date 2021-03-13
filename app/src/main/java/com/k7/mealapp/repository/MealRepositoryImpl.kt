package com.k7.mealapp.repository

import com.k7.mealapp.data.Meal
import com.k7.mealapp.network.MealApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val apiSource: MealApiService
) : MealRepository {

    override suspend fun getRandomMeals(): List<Meal> = withContext(Dispatchers.IO) {
        apiSource.getSearchFoodRandom().meals
    }

}
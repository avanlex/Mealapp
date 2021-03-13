package com.k7.mealapp.repository


import com.k7.mealapp.model.api.MealAPI
import com.k7.mealapp.network.MealApiService
import com.k7.mealapp.persistent.MealsDao
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val apiSource: MealApiService,
    private val db: MealsDao
) : MealRepository {

    override suspend fun getRandomMeals(): List<MealAPI> {
        return apiSource.getSearchFoodRandom().meals
    }

}
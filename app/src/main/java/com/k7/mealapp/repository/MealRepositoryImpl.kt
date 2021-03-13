package com.k7.mealapp.repository



import android.util.Log
import com.k7.mealapp.model.api.MealAPI
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.network.MealApiService
import com.k7.mealapp.persistent.MealsDao
import com.k7.mealapp.models.dto.convertToPojo
import com.k7.mealapp.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val apiSource: MealApiService,
    private val db: MealsDao
) : MealRepository {

    override suspend fun getRandomMeals(): List<MealDto> = withContext(Dispatchers.IO){

        return@withContext try {
            val mealsList = apiSource.getSearchFoodRandom()
            println("REPO" + mealsList.meals)
            mealsList.meals.map { it.convertToPojo() }
        }catch (e : Throwable){
            Log.d("REPO", e.message.toString())
            emptyList()
        }
    }

}
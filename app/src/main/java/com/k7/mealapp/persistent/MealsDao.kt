package com.k7.mealapp.persistent

import androidx.room.*

@Dao
interface MealsDao {

    @Query("SELECT * FROM meals")
    suspend fun getAllMeals(): List<MealEntity>

    @Query("DELETE FROM meals")
    suspend fun deleteAll()

    @Insert
    suspend fun insertMeals(meals: List<MealEntity>)

    @Update
    suspend fun updateMeal(meal: MealEntity)

//    @Delete
//    suspend fun deleteOldMeal(timeNow: Long)
}
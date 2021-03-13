package com.k7.mealapp.persistent

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MealEntity::class],
    version = 1
)

abstract class MealsDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao
}
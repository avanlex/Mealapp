package com.k7.mealapp.di.modules

import android.content.Context
import androidx.room.Room
import com.k7.mealapp.persistent.MealsDao
import com.k7.mealapp.persistent.MealsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MealsDatabase {
        return Room.databaseBuilder(context, MealsDatabase::class.java, "meals-db")
            .build()
    }
    @Provides
    @Singleton
    fun provideMealsDao(db: MealsDatabase): MealsDao = db.mealsDao()
}
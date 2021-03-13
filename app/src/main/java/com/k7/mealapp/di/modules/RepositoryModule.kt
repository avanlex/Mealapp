package com.k7.mealapp.di.modules

import com.k7.mealapp.repository.MealRepository
import com.k7.mealapp.repository.MealRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class,
        ApiServiceModule::class
    ]
)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMealRepository(mealRepository: MealRepositoryImpl): MealRepository
}
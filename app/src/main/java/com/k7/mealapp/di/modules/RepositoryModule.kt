package com.k7.mealapp.di.modules

import dagger.Module

@Module(
    includes = [
        DatabaseModule::class,
        ApiServiceModule::class
    ]
)
abstract class RepositoryModule {

}
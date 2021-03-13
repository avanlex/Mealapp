package com.k7.mealapp.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class CoreModule(private val application: Application) {

    @Provides
    fun provideApplication() = application

    @Provides
    fun provideContext() = application.applicationContext

    @Provides
    fun provideResoures() = application.resources
}
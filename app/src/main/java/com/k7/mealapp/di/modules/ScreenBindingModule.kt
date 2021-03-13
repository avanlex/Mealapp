package com.k7.mealapp.di.modules

import com.k7.mealapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
package com.k7.mealapp.di.modules

import com.k7.mealapp.MainActivity
import com.k7.mealapp.details.DetailsFragment
import com.k7.mealapp.mainscreen.ExploreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun detailsFragment(): DetailsFragment

    @ContributesAndroidInjector
    abstract fun exploreFragment(): ExploreFragment
}
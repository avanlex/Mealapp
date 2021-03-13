package com.k7.mealapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.k7.mealapp.di.vm.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}
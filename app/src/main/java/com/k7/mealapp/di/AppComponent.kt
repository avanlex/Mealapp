package com.k7.mealapp.di

import com.k7.mealapp.MealApplication
import com.k7.mealapp.di.modules.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiServiceModule::class,
        DatabaseModule::class,
        CoreModule::class,
        ScreenBindingModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MealApplication> {

    @Component.Builder
    interface Builder {
        fun coreModule(coreModule: CoreModule): Builder
        fun apiModule(apiServiceModule: ApiServiceModule): Builder

        fun build(): AppComponent
    }

}
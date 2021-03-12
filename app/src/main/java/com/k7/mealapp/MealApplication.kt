package com.k7.mealapp

import android.app.Application
import com.k7.mealapp.di.DaggerAppComponent
import com.k7.mealapp.di.modules.ApiServiceModule
import com.k7.mealapp.di.modules.CoreModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MealApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
            .coreModule(CoreModule(this))
            .apiModule(ApiServiceModule(BuildConfig.BASE_URL))
            .build()

        appComponent.inject(this)
    }

}
package com.k7.mealapp.di.modules

import android.app.Application
import com.google.gson.Gson
import com.k7.mealapp.network.MealApiService
import com.k7.mealapp.util.UtilRetrofit
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class ApiServiceModule(private val serverUrl: String) {

    @Provides
    @Singleton
    fun provideMealApi(
        okHttpClient: OkHttpClient,
        gson: Gson
    ) = createApi(MealApiService::class.java, okHttpClient, gson, serverUrl)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val okHttpLogger = HttpLoggingInterceptor()
        okHttpLogger.level = HttpLoggingInterceptor.Level.BODY

        return okHttpLogger
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MB
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson{
        return Gson()
    }

    private fun <T> createApi(
        serviceClazz: Class<T>,
        httpClient: OkHttpClient,
        gson: Gson,
        serverUrl: String,
    ): T {
        return UtilRetrofit
            .setupRetrofit(httpClient, gson, serverUrl)
            .create(serviceClazz)
    }
}
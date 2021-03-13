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

@Module
class ApiServiceModule(private val serverUrl: String) {

    @Provides
    fun provideMealApi(
        okHttpClient: OkHttpClient,
        gson: Gson
    ) = createApi(MealApiService::class.java, okHttpClient, gson, serverUrl)

    @Provides
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
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val okHttpLogger = HttpLoggingInterceptor()
        okHttpLogger.level = HttpLoggingInterceptor.Level.BODY

        return okHttpLogger
    }

    @Provides
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MB
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
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
package com.k7.mealapp.util

import com.google.gson.Gson
import com.k7.mealapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UtilRetrofit {
    fun setupRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        serverAddress: String
    ): Retrofit {
        val apiKey = BuildConfig.API_KEY
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("$serverAddress$apiKey/")
            .client(okHttpClient)
            .build()
    }
}
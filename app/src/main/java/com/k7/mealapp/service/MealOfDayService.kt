package com.k7.mealapp.service

import android.app.Service
import android.content.ContentValues
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MealOfDayService: Service() {

    val binder = MealOfDayServiceBinder()


    fun showNotification(){
        Log.i(ContentValues.TAG, "Уведомление!")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
    inner class MealOfDayServiceBinder : Binder() {
        fun getService(): MealOfDayService {
            return this@MealOfDayService
        }
    }

}